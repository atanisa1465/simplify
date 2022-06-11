import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;

//Did not write this class
//Source: GitHub --> for serialization of calendar

public class EventLinkedList extends FileReadAndWrite implements Iterable<Events>, Serializable {

    private class Node implements Serializable {

        private static final long serialVersionUID = 1L;
        Events event;
        Node next;

        public Node(Events event) {
            this(event, null);
        }

        public Node(Events event, Node next) {
            this.event = event;
            this.next = next;
        }
    }//end node class

    @Override
    public Iterator<Events> iterator() {
        if (start == null) {
            return Collections.<Events>emptyList().iterator();
        }
        return new Iterator<Events>() {
            private Node currentNode = start;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Events next() {
                if (currentNode == null) {

                }
                Events toReturn = currentNode.event;
                currentNode = currentNode.next;
                return toReturn;
            }

        };
    }

    private Node start;
    private static EventLinkedList uniqueEventList = new EventLinkedList();
    private static final long serialVersionUID = 1L;
    private int size;
    
    private EventLinkedList() {
        if (!getFile().exists()) {
            start = null;
        } else {//meaning file does exsist so there is eventList in the file
            try (ObjectInputStream inputObject = getObjectInputStream()) {
                uniqueEventList = (EventLinkedList) inputObject.readObject();
                start=uniqueEventList.start;//setting start
                size=uniqueEventList.size;//setting size
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("List is loaded");
            }
        }//end of else
    }

    public static EventLinkedList instanceOf() {
        return uniqueEventList;
    }
    
    public int getSize(){
        return size;
    }
    
    private void writeEventListToFile() {
        try (ObjectOutputStream sendToFile = getObjectOutputStream()) {
            sendToFile.writeObject(uniqueEventList);
        } catch (IOException io) {
            System.out.println("COULD NOT Write To File Error Check File path?!!");
        }
    }

    /**
     * removes specified event object by its toString
     *
     * @param eventToString
     */
    public void remove(String eventToString) {
        Node currentNode = start;
        if (currentNode.event.toString().equals(eventToString)) {
            start = start.next;
            writeEventListToFile();
            size--;
            return;
        }
        Node previousNode = null;

        while (currentNode != null && !currentNode.event.toString().equals(eventToString)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }//ends while when currentNode equals eventToString 

        if (currentNode == null) {//no node was found
            return;
        }
        //erasing the event in the list
        previousNode.next = currentNode.next;
        size--;
        writeEventListToFile();//writing to file after removing
    }

    /**
     *
     * method will keep event object sorted during the add process
     *
     * @param event
     *
     *
     */
    public void add(Events event) {
        if (start == null) {
            start = new Node(event);
        } else if (event.compareTo(start.event) <= -1) {//seeing if new event is before the current sorted event
            start = new Node(event, start);
        } else {
            Node nodePointer = start;
            //finding the location where @param event fits in sorted order
            while (nodePointer.next != null && event.compareTo(nodePointer.next.event) > 0) {
                nodePointer = nodePointer.next;
            }//end while   
            nodePointer.next = new Node(event, nodePointer.next);
        }
        size++;
        writeEventListToFile();//writing list to file after adding
    }


    public String toString() {
        StringBuilder formListString = new StringBuilder();
        if (start == null) {
            return "List is empty";
        } else {
            Node currentNode = start;
            while (currentNode != null) {
                formListString.append(currentNode.event.toString());
                currentNode = currentNode.next;
                if (currentNode != null) {//handles the last element in the list
                    formListString.append(", ");
                }
            }

        }
        return formListString.toString();
    }

}//end event linked list

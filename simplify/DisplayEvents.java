import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.*;

public class DisplayEvents extends JPanel {

    private DefaultListModel<String> eventModel;
    private JList<String> eventList;
    private JList<String> removeList;
    private DefaultListModel<String> removeModel;
    public DisplayEvents() {
        setBackground(new java.awt.Color(245, 247, 251));
        Box eventBox = Box.createVerticalBox();
        JPanel horizontal = initalizingEventList();
        eventBox.add(horizontal);
        this.add(eventBox);
        this.setVisible(true);
    }

    private void populateEventList() {
        try {
            for (Events currentEvent : EventLinkedList.instanceOf()) {
                eventModel.addElement(currentEvent.toString());
                removeModel.addElement("Remove");
            }
        } catch (NullPointerException n) {
            System.out.println("nothing planned for events");
        }
    }

    private JPanel initalizingEventList() {
        eventModel = new DefaultListModel();
        eventList = new JList<>(eventModel);
        eventList.setBackground(new java.awt.Color(245, 247, 251));
        eventList.setFixedCellHeight(35);
        eventList.setEnabled(false);
        eventList.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        eventList.setForeground(Color.BLACK);
        removeModel = new DefaultListModel();
        removeList = new JList<>(removeModel);
        removeList.setFixedCellHeight(35);
        removeList.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        removeList.setForeground(Color.BLACK);
        removeList.setBackground(new java.awt.Color(246, 232, 253));
        RemoveJListListener removeListen = new RemoveJListListener();
        removeList.addMouseListener(removeListen);
        populateEventList();
        JPanel horizontal = new JPanel();
        horizontal.setBackground(new java.awt.Color(245, 247, 251));
        horizontal.add(eventList);
        horizontal.add(removeList);
        return horizontal;
    }

    public void refreshGUI() {
        eventModel.clear();
        removeModel.clear();
        populateEventList();
    }

    private class RemoveJListListener implements MouseListener {
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = removeList.getSelectedIndex();
            EventLinkedList.instanceOf().remove(eventModel.get(index).toString());
            removeModel.remove(index);
            eventModel.remove(index);
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}

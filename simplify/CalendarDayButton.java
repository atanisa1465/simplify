import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CalendarDayButton extends JButton {
    private JLabel dayNumber;
    private JTextArea eventDescription;
    private GregorianCalendar tempCalendar;
    private JTabbedPane theAppTabs;
    
    public CalendarDayButton(int dayNum,GregorianCalendar tempCalendar,JTabbedPane theAppTabs) {
        this.tempCalendar = tempCalendar;
        this.theAppTabs = theAppTabs;
        dayNumber = new JLabel(Integer.toString(dayNum));
        this.setSize(100,150);
        setUpEventDescription();
        setUpButton();
    }

    public void setCurrentDay(){
        this.setBackground(Color.WHITE);
        eventDescription.setBackground(Color.WHITE);
    }
    
    public void setEventDescription(String eventToPlan) {
            StringBuilder eventString = new StringBuilder();
            eventString.append(eventDescription.getText() );
            eventString.append("\n");
            eventString.append(eventToPlan);
            eventDescription.setText(eventString.toString());
    }

    private void setUpEventDescription() {
        eventDescription = new JTextArea();
        eventDescription.setEditable(false);
        eventDescription.setBackground(new java.awt.Color(185, 216, 240));
        eventDescription.setLineWrap(true);
        eventDescription.setWrapStyleWord(true);
    }
    
    private void setUpButton() {
        this.setBackground(new java.awt.Color(185, 216, 240));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.TOP);
        this.setLayout(new BorderLayout());
        this.setPreferredSize((new Dimension(105, 82)));
        this.addActionListener(new DayListener());
        this.add(BorderLayout.NORTH, dayNumber); //sets date in top left
        this.add(BorderLayout.SOUTH, eventDescription); //sets event description in bottom
    }

    private class DayListener implements ActionListener {
    private String getMonth(int m) {
        String holder = Integer.toString(m);
        switch (m) {
            case (0): holder = "January"; break;
            case (1):  holder = "February"; break;
            case (2): holder = "March"; break;
            case (3): holder = "April"; break;
            case (4): holder = "May"; break;
            case (5): holder = "June"; break;
            case (6): holder = "July"; break;
            case (7): holder = "August"; break;
            case (8): holder = "September"; break;
            case (9): holder = "October"; break;
            case (10): holder = "November"; break;
            case (11): holder = "December"; break;
        } return holder;
    }
        @Override
        public void actionPerformed(ActionEvent e) {
                if (CalendarDayButton.this == e.getSource()){
                    Events eventPojo = new Events(dayNumber.getText() , getMonth(tempCalendar.get(Calendar.MONTH)), tempCalendar.get(Calendar.YEAR));
                    CreateEventForm createAEvent = new CreateEventForm(eventPojo, theAppTabs);
                    theAppTabs.add("Creating an Event", createAEvent);
                    theAppTabs.setSelectedComponent(createAEvent);
                    theAppTabs.setEnabledAt(0, false);
                    theAppTabs.setEnabledAt(1, false);
                } 
        }
    }

}
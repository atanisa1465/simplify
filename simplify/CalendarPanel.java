import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CalendarPanel extends JPanel {
    private JButton nextMonth, previousMonth;
    private int firstOfMonth;
    private GregorianCalendar tempCalendar;
    private final String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    Font monthFont = new java.awt.Font("Lucida Grande", 1, 35);
    Font buttonFont = new java.awt.Font("Lucida Grande", 0, 20);
    private CalendarDayButton[] dayButton;
    private JTabbedPane theAppTabs;
    private DisplayEvents eventTab;

    public CalendarPanel(JTabbedPane theAppTabs, DisplayEvents eventTab, GregorianCalendar tempCalendar) {
        setBackground(new java.awt.Color(245, 247, 251));
        this.tempCalendar = tempCalendar;
        this.theAppTabs = theAppTabs;
        this.eventTab = eventTab;
        this.setLayout(new GridBagLayout());
        displayTopPanel();
        displayWeekDayPanel();
        displayDayPanel(getDaysInAMonth());
        displayCalendarEvents();
        this.setSize(815,526);
        this.setVisible(true);
    }

    public void refreshGUI() {
        this.removeAll();
        this.updateUI();
        displayTopPanel();
        displayWeekDayPanel();
        displayDayPanel(getDaysInAMonth());
        displayCalendarEvents();
    }
    
    private void displayTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new java.awt.Color(245, 247, 251));
        JLabel monthLabel = new JLabel("    " + getMonth( tempCalendar.get(Calendar.MONTH) ) + " " + tempCalendar.get(Calendar.YEAR)+ "    ");
        monthLabel.setFont(monthFont);
        nextMonth = new JButton();
        nextMonth.setText(">>");
        nextMonth.setBackground(Color.white);

        NextPrevButton buttonClick = new NextPrevButton();
        nextMonth.addActionListener(buttonClick);
        
        previousMonth = new JButton();
        previousMonth.setText("<<");
        previousMonth.setBackground(Color.white);

        previousMonth.addActionListener(buttonClick);
        topPanel.add(previousMonth);
        topPanel.add(monthLabel);
        topPanel.add(nextMonth);
        addComponent(this, topPanel, 0, 0, 0, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
    }

    //This method sets the row and column display of each day (button) for the calendar
    //Did not write the majority of this method: from Stack Overflow
    private void displayDayPanel(int totalDays) {
        GregorianCalendar calendar = new GregorianCalendar(); //creates a calendar for today
        int currentYear = calendar.get(Calendar.YEAR); //is used to highlight current day
        int currentMonth = calendar.get(Calendar.MONTH); //is used to highlight current Day
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equalsIgnoreCase(findFirstOfMonth(tempCalendar))) { firstOfMonth = i + 2; }
        }
        int column = firstOfMonth;
        int row = firstOfMonth;
        dayButton = new CalendarDayButton[totalDays+1];
        for (int dayNumber = 1; dayNumber <= totalDays; dayNumber++) {
            dayButton[dayNumber] = new CalendarDayButton(dayNumber, tempCalendar, theAppTabs);
            if (tempCalendar.get(Calendar.DAY_OF_MONTH) == dayNumber && currentMonth == tempCalendar.get(Calendar.MONTH) && currentYear == tempCalendar.get(Calendar.YEAR)) {//if its today
                dayButton[dayNumber].setCurrentDay();
            }
            addComponent(this, dayButton[dayNumber], column, row, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
            if (row == 8) {
                row = 1;
                column = column + 1;
            } row++;
        }
    }

       private void displayCalendarEvents() {
        try {
            for (Events holdEvent : EventLinkedList.instanceOf()) {
                String event = holdEvent.getEvent();
                String month = holdEvent.getMonth();
                String day = holdEvent.getDay();
                String year = holdEvent.getYear();

                if (isThereAnEventThisMonth(month, year)) { dayButton[Integer.parseInt(day)].setEventDescription(event); }
                        String sendTextReminder = "";
                        if (isThereAnEventOnTodaysDate(month, year, day) ){}
                        if (new CurrentTime().getTime().equals(sendTextReminder)) {} 
                     }
                }
        catch (NullPointerException e) {
            System.out.println("No events have been made to populate calendar");
        }
    }

    private boolean isThereAnEventThisMonth(String month, String year) throws NumberFormatException {
        return month.equals(getMonth( tempCalendar.get(Calendar.MONTH) )) && Integer.parseInt(year)==tempCalendar.get(Calendar.YEAR);
    }
    private boolean isThereAnEventOnTodaysDate(String month, String year, String day) throws NumberFormatException {
        return month.equals(getMonth( tempCalendar.get( Calendar.MONTH ) )) && Integer.parseInt(year)==tempCalendar.get(Calendar.YEAR)&& Integer.parseInt(day)== tempCalendar.get(Calendar.DAY_OF_MONTH);
    }

    //sets weekday labels
    private void displayWeekDayPanel() {
       JLabel[] weekDayLabel = new JLabel[7];
        Border weekBorder = BorderFactory.createLineBorder(Color.white, 1);
        for (int i = 0; i < 7; i++) {
            weekDayLabel[i] = new JLabel(daysOfWeek[i], SwingConstants.CENTER); 
            weekDayLabel[i].setBorder(weekBorder);
            addComponent(this, weekDayLabel[i], 1, i + 2, 1, 1, GridBagConstraints.ABOVE_BASELINE_TRAILING, GridBagConstraints.HORIZONTAL);
        }
    }

    //Did not write this method 
    //Method used for calendar layout
    private void addComponent(JPanel thePan, Component c, int row, int column, int width, int height, int place, int stretch) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = column; // set gridx
        constraints.gridy = row; // set gridy
        constraints.gridwidth = width; // set gridwidth
        constraints.gridheight = height; // set gridheight
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = place;
        constraints.fill = stretch;
        thePan.add(c, constraints);
    }

    private int getDaysInAMonth() {
        return tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private String getMonth(int m) {
        String holder = Integer.toString(m);
        switch (m) {
            case (0): holder = "January"; break;
            case (1): holder = "February"; break;
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

    private String findFirstOfMonth(GregorianCalendar cal) {
        GregorianCalendar CLONE;
        CLONE = (GregorianCalendar) cal.clone();
        CLONE.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
        String firstDayOfTheMonth;
        firstDayOfTheMonth = CLONE.getTime().toString();
        return firstDayOfTheMonth.substring(0, 3);
    }

    private class NextPrevButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nextMonth) {
                tempCalendar.add(MONTH, 1);
                refreshGUI();
            } else if (e.getSource() == previousMonth) {
                tempCalendar.add(MONTH, -1);
                refreshGUI();
            }
        }
    }
     
}
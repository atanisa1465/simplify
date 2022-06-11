import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

public class CalendarApp extends javax.swing.JPanel {

    private final JTabbedPane TABS;
    private CalendarPanel calendarTab;
    private GregorianCalendar tempCalendar;

    public CalendarApp() {
        setBackground(new java.awt.Color(245, 247, 251));
        tempCalendar = new GregorianCalendar();
        TABS = new JTabbedPane();
        DisplayEvents eventTab = new DisplayEvents();
        calendarTab = new CalendarPanel(TABS, eventTab, tempCalendar);
        TABS.add("Calendar", calendarTab);
        TABS.add("Events", eventTab);

        TABS.addChangeListener((ChangeEvent e) -> {
            JTabbedPane tabSource = (JTabbedPane) e.getSource();
            String tabSelected = tabSource.getTitleAt(tabSource.getSelectedIndex());
            if (tabSelected.equals("Calendar")) {
                calendarTab.refreshGUI();
            } else if (tabSelected.equals("Events")) {
                eventTab.refreshGUI();
            }
        });

        CurrentTime theCurrentTimeNow = new CurrentTime();
        int TIME_TICK = 60000;
        new Timer(TIME_TICK, (ActionEvent e) -> {
            timerEvent(theCurrentTimeNow);
        }).start();
        add(TABS);
    }

    //Not my code: from Stack Overflow
    private void timerEvent(CurrentTime theCurrentTimeNow) throws HeadlessException {
        String midnight = "12:00 AM";
        if(theCurrentTimeNow.getTime().equals(midnight)){
            tempCalendar.add(Calendar.DATE, 1);
            calendarTab.refreshGUI();
        }
    }

}
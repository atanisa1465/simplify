import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Did not write the majority of this class
//Source: GitHub --> for sorting events in events display

public class Events implements Comparable<Events>, Serializable {
    private String event, month, day, year;
    private static final long serialVersionUID = 1L;
    public Events(String event, String day, String month, String year) {
        this.month = month;
        this.day = changeSingleDigitTooTwoDigit(day);
        this.year = year;
        this.event = event;
    }

    public Events(String day, String month, int year) {
        this.month = month;
        this.day = changeSingleDigitTooTwoDigit(day);
        this.year = Integer.toString(year);
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public void setDay(String day) { this.day = day; }
    public void setEvent(String event) { this.event = event; }
    public String getEvent() { return event; }
    public String getDay() { return day; }
    public String getYear() { return year; }
    
    private String changeSingleDigitTooTwoDigit(String singleDigit) {
        try {
            int valueOfSingleDigit = Integer.parseInt(singleDigit);

            if (valueOfSingleDigit < 10) {
                NumberFormat formatter = new DecimalFormat("00");
                String twoDigit = formatter.format(valueOfSingleDigit);
                return twoDigit;
            } else { return String.valueOf(singleDigit); }
        } catch (NumberFormatException num) {
            System.out.println(singleDigit + " <- is not an integer value");
            num.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private String getMonthNumeric() {
        String numericMonth;
        switch (month) {
            case ("January"):
                numericMonth = "00";
                break;
            case ("February"):
                numericMonth = "01";
                break;
            case ("March"):
                numericMonth = "02";
                break;
            case ("April"):
                numericMonth = "03";
                break;
            case ("May"):
                numericMonth = "04";
                break;
            case ("June"):
                numericMonth = "05";
                break;
            case ("July"):
                numericMonth = "06";
                break;
            case ("August"):
                numericMonth = "07";
                break;
            case ("September"):
                numericMonth = "08";
                break;
            case ("October"):
                numericMonth = "09";
                break;
            case ("November"):
                numericMonth = "10";
                break;
            default:
                numericMonth = "11";
                break;
        } return numericMonth;
    }

    private String ordinalIndicator(String day) {
        StringBuilder dayWithOrdinal = new StringBuilder();
        String regexToSetTH = "0[4-9]|1[4-9]|2[4-9]|10|20|30";
        Pattern theTHPattern = Pattern.compile(regexToSetTH);
        Matcher matchTH = theTHPattern.matcher(day);
        dayWithOrdinal.append(day);
        if (matchTH.matches()){ 
            dayWithOrdinal.append("th");
        } else if (day.equals("01") || day.equals("21") || day.equals("31")) {
            dayWithOrdinal.append("st");
        } else if ( day.equals("02")||day.equals("22") ) {
            dayWithOrdinal.append("nd");
        } else if (day.contains("3")) {
            dayWithOrdinal.append("rd");
        }
        return dayWithOrdinal.toString();
    }
  
    private String decideIfDescriptionIsABill() {
        String decide = (event.contains("$")) ? " is due" : "";
        return decide;
    }

    private String getDateOfEvent() {
        return String.format("%s %s %s", year, getMonthNumeric(), day);
    }

    @Override
    public String toString() {
        return String.format("%s%s on the %s of %s %s", event, decideIfDescriptionIsABill(), ordinalIndicator(day), month, year);
    }

    @Override
    public int compareTo(Events otherEvent) {
        return this.getDateOfEvent().compareTo(otherEvent.getDateOfEvent());
    }
}
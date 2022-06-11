import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
    public CurrentTime() {}
    
    public String getTime() {
        String currentTime;
        currentTime = setTime(new Date());
        return currentTime;
    }
    private String setTime(Date currentDate){
        DateFormat formatDate = new SimpleDateFormat("h:mm a");
        return formatDate.format(currentDate);
    }
}
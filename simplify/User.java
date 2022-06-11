import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    protected String outputFile;
    protected int courseComplete;
    protected int courseInProgress;
    
    public User(String n, String e, int c, int p) {
        name = n;
        email = e;
        courseComplete = c;
        courseInProgress = p;
    }

    public String firstName() {
        String first = "";
        for (int i = 0; i < name.length(); i++) {
            if (!name.substring(i,i+1).equals(" ")) {
                first += name.substring(i,i+1);
            } else { return first; }
        }
        return first;
    }

    public void setNum(int p) {courseInProgress = p;}
    public void setNumC(int c) {courseComplete = c;}
    public int getNum() { return courseInProgress;}
    public int getNumC() { return courseComplete;}

}

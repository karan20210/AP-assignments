import java.util.*;

public class comment {
    private String content;
    private Date d;
    private String name;

    public comment(String c, String n)
    {
        content = c;
        name = n;
        d = new Date();
    }

    public void viewComment()
    {
        System.out.println(content + " - " + name);
        System.out.println(d);
    }

}

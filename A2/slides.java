import java.util.*;

public class slides implements material {
    private String topic;
    private int no_of_slides;
    private ArrayList<String> contents;
    private Date date_of_material;
    private String ins_name;


    slides(String t, int n, ArrayList<String> c, instructor ins)
    {
        topic = t;
        no_of_slides = n;
        contents = c;
        date_of_material = new Date();
        ins_name = ins.getName();

    }

    @Override
    public void showMaterial()
    {
        System.out.println("Title: " + topic);
        System.out.println("Number of slides: " + no_of_slides);

        for(int i = 0; i<no_of_slides; i++)
        {
            System.out.println("Slide " + (i+1) + ": " + contents.get(i));
        }

        System.out.println("Date: " + date_of_material);

        System.out.println("Uploaded by: " + ins_name);

    }
    

    /**
     * @return String return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @return int return the no_of_slides
     */
    public int getNo_of_slides() {
        return no_of_slides;
    }

    /**
     * @param no_of_slides the no_of_slides to set
     */
    public void setNo_of_slides(int no_of_slides) {
        this.no_of_slides = no_of_slides;
    }

    /**
     * @return ArrayList<String> return the contents
     */
    public ArrayList<String> getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(ArrayList<String> contents) {
        this.contents = contents;
    }

    /**
     * @return Date return the date_of_material
     */
    public Date getDate_of_material() {
        return date_of_material;
    }

    /**
     * @param date_of_material the date_of_material to set
     */
    public void setDate_of_material(Date date_of_material) {
        this.date_of_material = date_of_material;
    }

}

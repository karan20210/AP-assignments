import java.util.*;

public class video implements material {
    private String topic;
    private String filename;
    private String ins_name;;
    private Date date_of_upload;

    video(String t, String f, instructor ins)
    {
        topic = t;
        filename = f;
        ins_name = ins.getName();
        date_of_upload = new Date();
    }

    @Override
    public void showMaterial()
    {
        System.out.println("Title of video: " + topic);
        System.out.println("Filename: " + filename);

        System.out.println("Date of upload: " + date_of_upload);
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
     * @return String return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return Date return the date_of_upload
     */
    public Date getDate_of_upload() {
        return date_of_upload;
    }

    /**
     * @param date_of_upload the date_of_upload to set
     */
    public void setDate_of_upload(Date date_of_upload) {
        this.date_of_upload = date_of_upload;
    }

}
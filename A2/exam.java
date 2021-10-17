public interface exam
{
    public void showAssessement();
    public String getStatus();
    public String getType();
    public boolean getGraded();
    public void grade(String name);
    public String getFileName();
    public int getMax_marks();
    public int getMarks();
    public void setMarks(int marks);
    public String getInsName();
    public void close();
    public boolean getClose();
}

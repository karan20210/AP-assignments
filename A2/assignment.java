public class assignment implements exam {

    private String problem_statement;
    private int max_marks;
    private String status;
    private String fileName;
    private boolean graded;
    private int marks;
    private String insName;
    private boolean close;

    assignment(String p, int m)
    {
        problem_statement = p;
        max_marks = m;
        status = "pending";
        graded = false;
        marks = 0;
        close = false;
    }


    assignment(assignment a)
    {
        this.problem_statement = a.problem_statement;
        this.max_marks = a.max_marks;
        this.status = a.status;
        this.fileName = a.fileName;
        this.graded = a.graded;
        this.marks = a.marks;
        this.close = a.close;
    }

    public void close()
    {
        this.close = true;
    }

    public boolean getClose()
    {
        return close;
    }

    @Override
    public void showAssessement()
    {
        System.out.println(" Assignment: " + problem_statement + " Max marks: " + max_marks);
    }

    /**
     * @return String return the problem_statement
     */
    public String getProblem_statement() {
        return problem_statement;
    }

    /**
     * @param problem_statement the problem_statement to set
     */
    public void setProblem_statement(String problem_statement) {
        this.problem_statement = problem_statement;
    }

    /**
     * @return int return the max_marks
     */
    public int getMax_marks() {
        return max_marks;
    }

    /**
     * @param max_marks the max_marks to set
     */
    public void setMax_marks(int max_marks) {
        this.max_marks = max_marks;
    }

    @Override
    public String getStatus()
    {
        return status;
    }

    @Override
    public String getType()
    {
        return "assignment";
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the fileName
     */
    @Override
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean getGraded()
    {
        return graded;
    }

    @Override
    public void grade(String name)
    {
        graded = true;
        insName = name;
    }

    /**
     * @return int return the marks
     */
    public int getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    @Override
    public String getInsName() {
        return insName;
    }

}

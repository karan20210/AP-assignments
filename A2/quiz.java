public class quiz implements exam {
    private String question;
    private String status;
    private boolean graded;
    private String answer;
    private int marks;
    private String insName;
    private boolean close;

    quiz(String q)
    {
        question = q;
        status = "pending";
        graded = false;
        marks = 0;
        close = false;
    }

    quiz(quiz q)
    {
        this.question = q.question;
        this.status = q.status;
        this.answer = q.answer;
        this.graded = q.graded;
        this.marks = q.marks;
        this.close = q.close;
    }

    @Override
    public void showAssessement()
    {
        System.out.println(" Question: " + question);
    }

    public void close()
    {
        this.close = true;
    }

    public boolean getClose()
    {
        return close;
    }

    /**
     * @return String return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String getType()
    {
        return "quiz";
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
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

    @Override
    public String getFileName()
    {
        return getAnswer();
    }

    @Override
    public int getMax_marks()
    {
        return 1;
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

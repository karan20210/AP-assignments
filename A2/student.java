import java.util.*;

public class student implements user {
    private Scanner scan_s = new Scanner(System.in);
    private Scanner scan_i = new Scanner(System.in);

    private String name;
    
    private ArrayList<exam> assessements = new ArrayList<>();

    public student(String n)
    {
        this.name = n;
    }

    @Override
    public void showMenu()
    {
        System.out.println();
        System.out.println("Welcome " + name);
        System.out.println("1. View lecture material");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessement");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
    }

    @Override
    public void viewMaterial(ArrayList<material> m)
    {
        System.out.println();
        for(material mat: m)
        {
            mat.showMaterial();
            System.out.println();
        }
    }

    @Override
    public void viewAssessements(ArrayList<exam> exams)
    {
        int cnt = 0;
        for(exam e: exams)
        {
            System.out.print("ID: " + cnt);
            e.showAssessement();
            cnt++;
        }

        if(cnt == 0)
        {
            System.out.println("No open assessements");
            return;
        }
    }

    public void submitAssessement()
    {
        System.out.println("Pending assessements:- ");
        int cnt = 0, flag = 0;
        for(exam e: this.assessements)
        {
            if(e.getStatus().equals("pending") && e.getClose() == false)
            {
                flag++;
                System.out.print("ID: " + cnt);
                e.showAssessement();
            }

            cnt++;
        }

        if(flag == 0)
        {
            System.out.println("No pending assessements :)");
            return;
        }

        System.out.print("Enter ID of assessement: ");
        int id = scan_i.nextInt();

        exam submit = assessements.get(id);

        if(submit.getType().equals("assignment"))
        {
            assignment a = (assignment)submit;

            System.out.print("Enter filename of assignment: ");
            String filename = scan_s.nextLine();

            int index = filename.indexOf(".");

            if(index == -1 || !filename.substring(index+1).equals("zip"))
            {
                System.out.println("Only upload zip files!!");
                return;
            }

            a.setFileName(filename);
            a.setStatus("submitted");
            
        }

        if(submit.getType().equals("quiz"))
        {
            quiz q = (quiz)submit;

            System.out.print(q.getQuestion()+ ": ");
            String ans = scan_s.nextLine();

            q.setAnswer(ans);
            q.setStatus("submitted");
        }
    }

    public void viewGrades()
    {
        System.out.println();
        System.out.println("Graded submissions:- ");

        for(exam e: assessements)
        {
            if(e.getGraded() == true && e.getStatus().equals("submitted"))
            {
                System.out.println("Submission: " + e.getFileName());
                System.out.println("Marks scored: " + e.getMarks());
                System.out.println("Graded by: " + e.getInsName());
                System.out.println();
            }
        }

        System.out.println("Ungraded submissions:- ");
        for(exam e: assessements)
        {
            if(e.getGraded() == false && e.getStatus().equals("submitted"))
            {
                System.out.println("Submission: " + e.getFileName());
            }
        }
    }

    @Override
    public comment addComments()
    {
        System.out.print("Enter comment: ");
        String comment_content = scan_s.nextLine();
        comment c = new comment(comment_content, name);
        return c;
    }

    @Override
    public void viewComments(ArrayList<comment> c)
    {
        System.out.println();
        for(comment i: c)
        {
            i.viewComment();
            System.out.println();
        }
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public void addAssessement(exam e)
    {
        if(e.getType().equals("assignment"))
        {  
            assignment temp = (assignment)e;
            assignment copy = new assignment(temp);
            assessements.add(copy);
        }

        else
        {
            quiz temp = (quiz)e;
            quiz copy = new quiz(temp);
            assessements.add(copy);
        }
    }

    public void closeAssessement(int id)
    {
        assessements.get(id).close();
        // if we need to show the grade after removal then add an attribute open to assingment and quiz smh like that
    }

    public ArrayList<exam> getAssessements()
    {
        return assessements;
    }
}

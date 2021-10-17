import java.util.*;

public class instructor implements user
{

    private Scanner scan_s = new Scanner(System.in);
    private Scanner scan_i = new Scanner(System.in);

    private ArrayList<user> students = new ArrayList<>();
    private String name;

    public instructor(String n, ArrayList<user> students)
    {
        this.name = n;
        this.students = students;
    }

    @Override
    public void showMenu()
    {
        System.out.println();
        System.out.println("Welcome " + name);
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessment");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");
    }

    public material addClassMaterial()
    {
        System.out.println();
        System.out.println("1. Add Lecture slide");
        System.out.println("2. Add Lecture video");
        int choice = scan_i.nextInt();

        material m = null;
        if(choice == 1)
        {
            System.out.print("Enter topic of slides: ");
            String topic = scan_s.nextLine();

            System.out.print("Enter number of slides: ");
            int no_of_slides = scan_i.nextInt();

            System.out.println("Enter content of slides");
            String content;
            ArrayList<String> slide_contents = new ArrayList<>();

            for(int i = 0; i<no_of_slides; i++)
            {
                System.out.print("Content of slide " + (i+1) + ": ");
                content = scan_s.nextLine();
                slide_contents.add(content);
            }

            m = new slides(topic, no_of_slides, slide_contents, this);
        }

        if(choice == 2)
        {
            System.out.print("Enter topic of video: ");
            String topic = scan_s.nextLine();

            System.out.print("Enter filename: ");
            String filename = scan_s.nextLine();

            m = new video(topic, filename, this);
        }

        return m;
    }

    public exam addAssessements()
    {
        System.out.println();
        System.out.println("1. Add Assignment");
        System.out.println("2. Add Quiz");
        int choice = scan_i.nextInt();

        exam e = null;

        if(choice == 1)
        {
            System.out.print("Enter problem statement: ");
            String ps = scan_s.nextLine();

            System.out.print("Enter max marks: ");
            int mm = scan_i.nextInt();

            e = new assignment(ps, mm);
        }

        if(choice == 2)
        {
            System.out.print("Enter quiz question: ");
            String qq = scan_s.nextLine();

            e = new quiz(qq);
        }

        for(user i: students)
        {
            student j = (student)i;
            j.addAssessement(e);
        }

        return e;
    }

    public void gradeAssessements(ArrayList<exam> e)
    {
        System.out.println("List of assessements");
        viewAssessements(e);

        System.out.print("Enter ID of submission to view submissions: ");
        int a_id = scan_i.nextInt();

        System.out.println("Choose ID from these ungraded submissions:-  ");
        int cnt = 0, t = 0;;
        for(user s: students)
        {
            student s1 = (student)s;
            ArrayList<exam> assessements = s1.getAssessements();
            if(assessements.get(a_id).getStatus().equals("submitted") && assessements.get(a_id).getGraded() == false)
            {
                t++;
                System.out.println(cnt + ". " + s1.getName());
            }
            cnt++;
        }

        if(t == 0)
        {
            System.out.println("No ungraded submissions :) ");
            return;
        }

        int id = scan_i.nextInt();
        user temp = students.get(id);
        student s = (student)temp;

        exam grading = s.getAssessements().get(a_id);

        System.out.println("Submission: " + grading.getFileName());
        System.out.println("-----------------");
        System.out.println("Max marks: " + grading.getMax_marks());
        System.out.print("Marks scored: ");
        int marks = scan_i.nextInt();
        if(marks > grading.getMax_marks())
        {
            System.out.println("Marks should be less than max_marks!!");
            return;
        }

        grading.setMarks(marks);
        grading.grade(name);
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

    public ArrayList<exam> closeAssessements(ArrayList<exam> e)
    {
        System.out.println();
        System.out.println("List of open assessements:- ");

        int cnt = 0, flag = 0;
        for(exam i: e)
        {
            flag++;
            System.out.print("ID: " + cnt + " ");
            i.showAssessement();
            cnt++;
        }

        if(flag == 0)
        {
            System.out.println("No open assessements");
            return e;
        }

        System.out.print("Enter id of assessement to be closed: ");
        int id = scan_i.nextInt();

        e.remove(id); 

        for(user i: students)
        {
            student j = (student)i;
            j.closeAssessement(id);
        }

        return e;
    }

    @Override
    public void addComments()
    {
        System.out.println("Add comments instructor: ");
    }

    @Override
    public void viewComments()
    {
        System.out.println("View comments instructor: ");
    }

    @Override
    public String getName()
    {
        return this.name;
    }
}
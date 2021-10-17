import java.util.*;

public class course {

    private Scanner scan_s = new Scanner(System.in);
    private Scanner scan_i = new Scanner(System.in);

    private ArrayList<user> instructors = new ArrayList<>();
    private ArrayList<user> students = new ArrayList<>();

    private ArrayList<material> materials = new ArrayList<>();
    private ArrayList<exam> exams = new ArrayList<>();

    String current;

    user currentUser;

    public course()
    {
        student s0 = new student("S0");
        students.add(s0);
        student s1 = new student("S1");
        students.add(s1);
        student s2 = new student("S2");
        students.add(s2);

        instructor i0 = new instructor("I0", students);
        instructors.add(i0);
        instructor i1 = new instructor("I1", students);
        instructors.add(i1);
    }

    public void displayMenu()
    {
        System.out.println("1. Enter as instructor");
        System.out.println("2. Enter as Student");
        System.out.println("3. Exit");

        int choice = scan_i.nextInt();

        if(choice == 1)
        {
            chooseUser(choice);
        }

        if(choice == 2)
        {
            chooseUser(choice);
        }
    }

    public void chooseUser(int choice) 
    {
        ArrayList<user> users = new ArrayList<>();
        if(choice == 1)
        {
            users = instructors;
            current = "instructor";
        }
        else
        {
            users = students;
            current = "student";
        }

        int cnt = 0;
        for(user i : users)
        {
            System.out.println(cnt + " - " + i.getName());
            cnt++;
        }

        System.out.print("Choose id: ");
        int id = scan_i.nextInt();

        if(id > cnt - 1 || id < 0)
        {
            System.out.println("Instructor does not exist!!");
        }

        else
        {
            cnt = 0;
            for(user i: users)
            {
                if(cnt == id)
                {
                    currentUser = i;
                    Menu();
                    return;
                }
                cnt++;
            }
        }
    }

    public void Menu()
    {
        currentUser.showMenu();

        System.out.print("Choose option: ");
        int opt = scan_i.nextInt();

        if(current.equals("instructor"))
        {
            instructor ins = (instructor)currentUser;
            switch(opt)
            {
                case 1: materials.add(ins.addClassMaterial());
                        break;
                
                case 2: exam e = ins.addAssessements();
                        exams.add(e);
                        break;
                
                case 3: currentUser.viewMaterial(materials);
                        break;
                
                case 4: currentUser.viewAssessements(exams);
                        break;
                
                case 5: ins.gradeAssessements(exams);
                        break;

                case 6: exams = ins.closeAssessements(exams);
                        break;

                case 9: System.out.println("Logging out...");
                        Logout();
                        return;
            }

            Menu();
        }

        else if(current.equals("student"))
        {
            student stu = (student)currentUser;

            switch(opt)
            {
                case 1: currentUser.viewMaterial(materials);
                        break;
                
                case 2: currentUser.viewAssessements(exams);
                        break;
                    
                case 3: stu.submitAssessement();
                        break;
                
                case 4: stu.viewGrades();
                        break;


                case 7: System.out.println("Logging out...");
                        Logout();
                        return;
            }

            Menu();
        }
    }

    public void Logout()
    {
        displayMenu();
    }

    public ArrayList<user> getInstructors()
    {
        return instructors;
    }

    public ArrayList<user> getStudents()
    {
        return students;
    }
    
}


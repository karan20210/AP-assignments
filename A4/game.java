import java.util.*;

public class game {
    
    private player current_player;
    private carpet c;
    Scanner scan_s = new Scanner(System.in);
    Scanner scan_i = new Scanner(System.in);

    public game()
    {
        System.out.println("Game is ready");
        current_player = new player(this);
        c = new carpet();
    }

    public player getCurrent_player() {
        return current_player;
    }

    public void setCurrent_player(player current_player) {
        this.current_player = current_player;
    }

    public carpet getCarpet()
    {
        return c;
    }
    
    public boolean generateQuestion()
    {
        String choice;
    
        Random random = new Random();

        while(true)
        {
            System.out.println("Question answer round. Integer or strings?");
            choice = scan_s.nextLine();

            if(choice.equals("integer"))
            {
                int no1 = 0;
                int no2 = 1;

                while(no1 < no2)
                {
                    no1 = random.nextInt(1000) + 1;
                    no2 = random.nextInt(1000) + 1;
                }
                

                System.out.println("Calculate the result of " + no1 + " divided by " + no2);
                calculator<Integer> intCalc = new calculator<Integer>(no1, no2);

                boolean done = false;

                while(!done)
                {
                    try
                    {
                        Scanner sc = new Scanner(System.in);
                        int ans = sc.nextInt();
                        done = true;
                        return intCalc.check(ans);
                    }
                    
                    catch(InputMismatchException e)
                    {
                        System.out.println("Wrong input.. Try Again");
                    }
                }       
            }

            if(choice.equals("string"))
            {
                String s1 = generateRandomString();
                String s2 = generateRandomString();

                System.out.println("Write the concatenation of " + s1 + " and " + s2);
                calculator<String> stringCalc = new calculator<String>(s1, s2);

                boolean done = false;

                while(!done)
                {
                    try
                    {
                        String ans = scan_s.nextLine();
                        done = true;
                        return stringCalc.check(ans);
                    }

                    catch(InputMismatchException e)
                    {
                        System.out.println("Wrong input.. Try Again");
                    }
                }      
            }

            else
            {
                System.out.println("Input integer or string ONLY");
                continue;
            }
        }
    }

    public static String generateRandomString()
    {
        char s1_1, s1_2, s1_3, s1_4;

        Random random = new Random();
        int a = random.nextInt(90-65) + 65;
        s1_1 = (char)a;
        a = random.nextInt(90-65) + 65;
        s1_2 = (char)a;
        a = random.nextInt(90-65) + 65;
        s1_3 = (char)a;
        a = random.nextInt(90-65) + 65;
        s1_4 = (char)a;

        String s1 = "" + s1_1 + s1_2 + s1_3 + s1_4;
        return s1;
    }
}

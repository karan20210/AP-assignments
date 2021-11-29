import java.util.*;

public class a4
{

    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);

        boolean done = false;

        while(!done)
        {
            try
            {
                System.out.println("Hit enter to initialize the game");
                String input = sc.nextLine();
                if(input.equals(""))                
                {
                    done = true;
                    game g = new game();
                    int i = 1;
                    while(i<=5)
                    {
                        try
                        {
                            System.out.println("Hop number " + i);
                            String p = sc.nextLine();
                            if(p.equals(""))
                                g.getCurrent_player().play();
                            else
                                throw new InputNotValidException("Input only ENTER key");
                            i++;
                        }

                        catch(InputNotValidException e)
                        {
                            System.out.println(e.getMessage());    
                        }
                        
                    }

                    System.out.println("Game over, You won:-");
                    bucket b = g.getCurrent_player().getBucket();
                    for(softToy s: b.getToys())
                    {
                        System.out.println(s.getName());
                    }
                    
                }

                else
                    throw new InputNotValidException("Input only ENTER key");
            }

            catch(InputNotValidException e)
            {
                System.out.println(e.getMessage());    
            }
        }
        sc.close();
        
    }
    
}
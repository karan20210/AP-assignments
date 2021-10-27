import java.util.*;

public class a3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan_i = new Scanner(System.in);

        System.out.println("Enter no. of players: ");
        int no_of_players = scan_i.nextInt();

        HashMap<String, player> players = new HashMap<>();

        for(int i = 0; i<no_of_players; i++)
        {
            System.out.println("Enter player name and hit Enter");
            String name = scan.nextLine();
            player p = new player(name);
            players.put(p.getName(), p);
        }
        
        for(player p: players.values())
        {
            while(true)
            {
                System.out.println("Hit enter to roll the dice, " + p.getName());
                String input = scan.nextLine();
                if(!input.equals(""))
                    break;
                int x = p.play(); 
                if(x==1)
                    break;
            }
        }

        System.out.println("Final scores!!");
        for(player p: players.values())
        {
            System.out.println(p.getName() + ": " + p.getTotal_points());
        }
    }
}

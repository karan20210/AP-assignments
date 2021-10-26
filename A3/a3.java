import java.util.*;

public class a3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter player name and hit Enter");
        String name = scan.nextLine();

        player p = new player(name);

        while(true)
        {
            System.out.println("Hit enter to roll the dice");
            String input = scan.nextLine();
            if(!input.equals(""))
                break;
            p.play();
        }
        
    }
}

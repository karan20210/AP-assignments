import java.util.*;

public class player {
    
    private game g;
    private bucket b;

    public player(game g)
    {
        this.g = g;
        b = new bucket();
    }

    public void play()
    {
        Random random = new Random();
        int tile_number = random.nextInt(21) + 1;
        boolean win_toy = true;

        try
        {
            softToy toy_won = g.getCarpet().getTiles().get(tile_number-1).winToy();
            System.out.println("Landed on tile number: " + tile_number);

            if(tile_number % 2 != 0)
                win_toy = g.generateQuestion();
            else
                win_toy = true;
            
            if(win_toy)
            {
                System.out.println("You won " + toy_won.getName());
                b.addToy(toy_won);
            }
            
            else
            {
                System.out.println("Incorrect Answer :((");
                System.out.println("You did not win a toy");
            }
        }

        catch(IndexOutOfBoundsException e)
        {
            System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
        }
    }

    public bucket getBucket()
    {
        return b;
    }
}

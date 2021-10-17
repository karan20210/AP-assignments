import java.util.ArrayList;

interface user
{
    public void showMenu();
    public void viewMaterial(ArrayList<material> m);
    public void viewAssessements(ArrayList<exam> e);
    public void viewComments();
    public void addComments();
    public String getName();
}
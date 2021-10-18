import java.util.ArrayList;

interface user
{
    public void showMenu();
    public void viewMaterial(ArrayList<material> m);
    public void viewAssessements(ArrayList<exam> e);
    public void viewComments(ArrayList<comment> c);
    public comment addComments();
    public String getName();
}
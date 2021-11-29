public class calculator<T> {
    private T x1;
    private T x2;

    public calculator(T n1, T n2)
    {
        x1 = n1;
        x2 = n2;
    }

    public boolean check(T ans)
    {
        if(ans instanceof Integer)
        {
            int a = (Integer)x1;
            int b = (Integer)x2;
            int c = (Integer)ans;

            return (c == a/b);        
        }

        else
        {
            String a = (String)x1;
            String b = (String)x2;
            String c = (String)ans;

            return (c.equals(a+b));
        }
    }
}

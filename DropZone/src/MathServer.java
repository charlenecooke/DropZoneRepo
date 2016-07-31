import org.rfaisal.math.MathService.Iface;

public class MathServer implements Iface
{
    public MathServer() { }
    public int add(int a, int b)
    {
        System.out.println("Called add({" + a + "},{" +b+ "})={" + (a+b) + "}");
        return a + b;
    }
    public int sub(int a, int b)
    {
    	System.out.println("Called sub({" + a + "},{" +b+ "})={" + (a-b) + "}");
        return a - b;
    }
    public int mul(int a, int b)
    {
    	System.out.println("Called mul({" + a + "},{" +b+ "})={" + (a*b) + "}");
        return a * b;
    }
    public int div(int a, int b)
    {
    	System.out.println("Called div({" + a + "},{" +b+ "})={" + (a/b) + "}");
        return a / b;
    }
    public int mod(int a, int b)
    {
    	System.out.println("Called mod({" + a + "},{" +b+ "})={" + (a%b) + "}");
        return a % b;
    }
}
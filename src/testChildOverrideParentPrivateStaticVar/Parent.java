package testChildOverrideParentPrivateStaticVar;

public class Parent {

    private static int x = 5;

    public void print(){
        System.out.println("x = "+x);
    }
}

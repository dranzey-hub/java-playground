package testChildOverrideParentPrivateStaticVar;

public class Test
{
    public static void main(String[] args) {

        Parent p = new Parent();
        //p.print();

        Child c = new Child();
        c.print();
    }

}

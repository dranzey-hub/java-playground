package estadistica.moda;

public class Main {


    public static void main(String[] args) {
        Moda moda = new Moda();

        System.out.print(moda.find(new int[]{0,2,3,2,1,2,3}));
    }
}

package _playground;


public class Playground {

    public static int number;
    public static boolean ready;

    public static void main(String[] args) throws InterruptedException
    {
        /**
         * Data race? i don't think so...
         */
        /*
        Thread thread = new MyThread();

        thread.start();

        number = 42;
        ready = true;*/

        /**
         * Get instance type of primitive elements
         */
        int x=1;
        System.out.println(((Object)x).getClass().getSimpleName());
    }





    private static class MyThread extends Thread{
        @Override
        public void run(){
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }
}

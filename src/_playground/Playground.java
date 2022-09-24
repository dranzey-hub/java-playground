package _playground;


public class Playground {

    public static int number;
    public static boolean ready;

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new MyThread();

        thread.start();

        number = 42;
        ready = true;
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

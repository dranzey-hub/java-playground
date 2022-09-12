package _playground;

import java.util.Arrays;
import java.util.List;

public class Playground {

    public static void main(String[] args)
    {
        Thread thread = new MyThread();

        System.out.println(thread.getClass().getSimpleName());
    }







    private static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("running thread "+this.getName());
        }
    }
}

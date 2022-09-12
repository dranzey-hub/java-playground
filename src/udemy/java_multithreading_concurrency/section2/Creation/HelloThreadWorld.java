package udemy.java_multithreading_concurrency.section2.Creation;

import utils.ConsoleColor;

public class HelloThreadWorld {

    public static void main(String[] args)
    {
        Thread thread = new Thread(
                ()-> System.out.println(ConsoleColor.RED_BOLD +"hello from "+Thread.currentThread().getName()+ConsoleColor.RESET)
        );
        thread.setName("thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Before starting the new thread.\n\tWe're in thread: "+Thread.currentThread().getName());
        thread.start();
        System.out.println("After starting the new thread.\n\tWe're in thread: "+Thread.currentThread().getName());

        try{Thread.sleep(10000);} catch(Exception e){}

    }
}

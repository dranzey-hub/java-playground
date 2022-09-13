package udemy.java_multithreading_concurrency.section5.DataSharingBetweenThreads;

import utils.ConsoleColor;

/**
 * Only data inside the heap can be shared between threads.
 *
 *         heap                 stack
 *      ------------        ------------
 *      -objects            -local primitives
 *      -class members      -local references (note: ref != object)
 *      -static vars
 *
 *   ..basically anything that is scoped outside methods
 */
public class InventoryCounter
{
    public static void main(String[] args) throws InterruptedException
    {
        Inventory inventory = new Inventory();
        IncrementingThread inc = new IncrementingThread(inventory);
        DecrementingThread dec = new DecrementingThread(inventory);

        //running the increment and decrement sequentially
        inc.start();
        inc.join();
        dec.start();
        dec.join();

        System.out.println("We currently have "+inventory.getItems()+" items.");

        //The above gives the correct result, but the problem of resource sharing comes with concurrency:
        inc = new IncrementingThread(inventory);
        dec = new DecrementingThread(inventory);

        inc.start(); dec.start();
        inc.join();  dec.join();

        System.out.println("We currently have "+inventory.getItems()+" items. "+ ConsoleColor.RED_BOLD+"(probably wrong)");


        /**
         * So what happened? If after all there's x operations on one side and x on the other, in the end no matter the
         *   order they should end up balancing to 0... the problem is the -- & ++ operations are not atomic, they
         *   consist on 3 steps: getting the current value of the variable, calculating the new value and then assigning
         *   that new value to the variable, which results in some operations overriding the result of another operation.
         */
    }

    private static class Inventory
    {
        private int items = 0;

        public void increment(){
            items++;
        }

        public void decrement(){
            items--;
        }

        public int getItems(){
            return items;
        }
    }

    public static class DecrementingThread extends Thread
    {
        private Inventory inventory;

        public DecrementingThread(Inventory inv){
            this.inventory = inv;
        }

        @Override
        public void run(){
            for(int i=0; i<10000; i++)  inventory.decrement();
        }
    }

    public static class IncrementingThread extends Thread
    {
        private Inventory inventory;

        public IncrementingThread(Inventory inv){
            this.inventory = inv;
        }

        @Override
        public void run(){
            for(int i=0; i<10000; i++)  inventory.increment();
        }
    }
}

// 1
package udemy.java_multithreading_concurrency.section6.Concurrency;

import utils.ConsoleColor;

/**
 * Now that we know the critical sections of our code in regards to concurrency, we can apply either:
 *
 *  1. Make the critical methods synchronized
 *  2. Have a synchronized block only on the particularly critical sections
 *
 *  Note that 2. is the same as 1. if:
 *      public void increment() { synchronized(this){ #implement all method code here} }
 *  Where we use the current object (this) as the monitor and the block extends the whole method code
 *
 *  Note that having a lock on a particular section will prevent another thread from accessing all
 *  locked parts on the object in question that use the same monitor.
 *      e.g. making the increment() and decrement() methods synchronized or
 *      having a synchronized block on both AND using the same monitor object
 *      will prevent another thread from accessing both while either of those methods is being executed.
 */
public class InventoryCounter_sync
{
    public static void main(String[] args) throws InterruptedException
    {
        Inventory inventory = new Inventory();
        IncrementingThread inc = new IncrementingThread(inventory);
        DecrementingThread dec = new DecrementingThread(inventory);

        inc.start(); dec.start();
        inc.join();  dec.join();

        System.out.println("We currently have "+inventory.getItems()+" items.");
    }

    private static class Inventory
    {
        private int items = 0;
        Object lock = new Object();
        //Either this:

        public synchronized void increment(){
            items++;
        }

        public synchronized void decrement(){
            items--;
        }

        //Or this:
        /*
        public void increment(){
            synchronized(this.lock){
                items++;
            }
        }

        public void decrement(){
            synchronized(this.lock){
                items--;
            }
        }
*/
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
            for(int i=0; i<100000; i++)  inventory.decrement();
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
            for(int i=0; i<100000; i++)  inventory.increment();
        }
    }
}

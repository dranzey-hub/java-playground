// 2
package udemy.java_multithreading_concurrency.section6.Concurrency;

/**
 * As opposed to a Race Condition (2+ threads that could access same resources), the Data Race problem arises
 *  because compilers and CPUs may execute instructions Our of Order due to optimization.
 */
public class DataRace {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedObject = new SharedClass();

        Thread incrementer = new Thread(()->{
           for(int i=0; i<Integer.MAX_VALUE; i++){
               sharedObject.increment();
           }
        });

        Thread checker = new Thread(()->{
            for(int i=0; i<Integer.MAX_VALUE; i++){
                sharedObject.checkDataRace();
            }
        });

        long startTime = System.currentTimeMillis();

        incrementer.start();
        checker.start();
        incrementer.join();
        //checker.join();

        long endTime = System.currentTimeMillis();
        System.out.println("time: "+(endTime-startTime));
    }


    public static class SharedClass{
        private volatile int x = 0;
        private volatile int y = 0;

        public void increment(){
            x++;
            y++;
        }

        /**
         * What's happening?!  ...data race
         *  which gets fixed by declaring the vars volatile, this ensures the operations execute in order
         *  (instructions before and after the read or write of the vars).
         *  [!] BUT, it takes much more time to process. (Over 100 times!)
         */
        public void checkDataRace(){
            if(y>x){
                DataRace.counter++;
                System.out.println(DataRace.counter+" y > x  <-- data race detected");
            }
        }
    }

}

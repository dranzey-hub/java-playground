package udemy.java_multithreading_concurrency.section3.Coordination;

import utils.ConsoleColor;

import java.math.BigInteger;

public class ThreadTermination {

    /**
     *  we can terminate a thread (interrupt) by either calling the .interrupt() like here below
     *   or if the thread itself handles the interruption on its code (see below 2nd implementation):
     */
    public static void main(String[] args)
    {/*
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        //thread takes forever to finish...
        for(int i=0; i<6;){
            try{Thread.sleep(1000);} catch(Exception e) {}

            if(i==5) {System.out.println("process takes forever to finish, let's try to interrupt it from this main thread...  "); break;}
            else     System.out.println(++i+"s");
        }
        //let's try to interrupt it
        thread.interrupt();*/

        /**
         * the .interrupt() will only work if the executing method throws InterruptedException.
         *
         *
         * The other way is by handling it on the thread itself:
         */

        //If we pass high numbers we might be here for a long time...
        Thread thread2 = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("1000000000")));

        thread2.start();
        //this won't work:
        thread2.interrupt();    //since there's no InterruptedException or any logic within the thread to interrupt it

        //after adding the interrupt logic on the LongComputationTask:
    }


    private static class BlockingTask implements Runnable
    {
        @Override
        public void run(){
            try{
                Thread.sleep(9999999);
            } catch(InterruptedException ie) {
                System.out.println("\n\t\"Interrupted Exception thrown from blocking task\"");
            }
        }
    }



    private static class LongComputationTask implements Runnable
    {
        BigInteger base;
        BigInteger power;

        public LongComputationTask(BigInteger b, BigInteger p){
            this.base = b;
            this.power = p;
        }

        @Override
        public void run()
        {
            System.out.println(base+"^"+power+" = "+ pow(base, power) );
        }



        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) !=0; i=i.add(BigInteger.ONE)){
                /**
                 * Interruption logic
                 */
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(ConsoleColor.RED_BOLD+"Interrupting computation!");  return BigInteger.ZERO;
                }

                result = result.multiply(base);
            }

            return result;
        }
    }
}

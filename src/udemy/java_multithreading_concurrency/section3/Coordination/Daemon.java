package udemy.java_multithreading_concurrency.section3.Coordination;

import utils.ConsoleColor;

import java.math.BigInteger;

/**
 * If we make a daemon thread then it will be 'naturally' interrupted when no threads are running
 */
public class Daemon {

    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(new LongComputationTask(new BigInteger("99999"), new BigInteger("999999999999")));

        daemon.setDaemon(true);
        daemon.start();
        //time out:
        Thread.sleep(1000);
        //daemon.interrupt();   this doesn't really do anything, since no interruption logic is set
        //the program exits since main threads are over and just this daemon persists
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
                result = result.multiply(base);
            }

            return result;
        }
    }
}

package udemy.java_multithreading_concurrency.section3.Coordination;

import utils.ConsoleColor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinMe
{
    public static void main(String[] args) throws InterruptedException
    {
        List<VariableLoadTask> taskList = new ArrayList<>();
        List<Long> inputList = Arrays.asList(0L,3435L,34567L,222L,12L,4L);

        for(long i : inputList){
            taskList.add(new VariableLoadTask(i));
        }

        for(VariableLoadTask t : taskList){
            t.setDaemon(true);                  //set them as daemons so we don't wait for them to exit the application
            t.start();
            t.join(100);                   //main thread waits only 100 ms for the thread to finish
        }

        for(int i=0; i<taskList.size(); i++){
            VariableLoadTask t = taskList.get(i);
            if (!t.isFinished) {
                System.out.println(ConsoleColor.RED_BOLD+"Thread "+t.getName()+" has not yet finished."+ConsoleColor.RESET);
            } else {
                System.out.println("Result from thread "+t.getName()+": "+t.result);
            }
        }

    }



    private static class VariableLoadTask extends Thread
    {
        boolean isFinished = false;
        BigInteger result = BigInteger.ZERO;
        long input;

        public VariableLoadTask(long input){
            this.input = input;
        }

        @Override
        public void run(){
            result = factorial(input);
            isFinished = true;
        }

        private BigInteger factorial(long n){
            BigInteger r = BigInteger.ONE;
            for(long i=n; i>0; i--){
                r = r.multiply(new BigInteger(Long.toString(i)));
            }
            return r;
        }
    }
}

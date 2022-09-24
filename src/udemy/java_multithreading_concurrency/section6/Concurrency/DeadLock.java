//3
package udemy.java_multithreading_concurrency.section6.Concurrency;

import java.util.Random;

public class DeadLock
{
    public static void main(String[] args)
    {
        Intersection intersection = new Intersection();

        Thread threadA = new Thread(new TrainA(intersection)); threadA.setName("Train A");
        Thread threadB = new Thread(new TrainB(intersection)); threadB.setName("Train B");

        threadA.start();
        threadB.start();
    }


    public static class Intersection{
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA(){
            synchronized (roadA){
                System.out.println("Road A is being taken by "+Thread.currentThread().getName()+" --locking road A");

                synchronized (roadB){
                    System.out.println("\tTrain passing through road A --locking road B");
                    try{Thread.sleep(1);} catch(InterruptedException e){}
                }
            }
        }

        public void takeRoadB(){
            synchronized (roadB){
                System.out.println("Road B is being taken by "+Thread.currentThread().getName()+" --locking road B");

                synchronized (roadA){
                    System.out.println("\tTrain passing through road B --locking road A");
                    try{Thread.sleep(1);} catch(InterruptedException e){}
                }
            }
        }
    }

    public static class TrainA implements Runnable{
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection){
            this.intersection = intersection;
        }

        @Override
        public void run(){
            while(true){
                long sleepingTime = random.nextInt(5);
                try{Thread.sleep(sleepingTime);} catch(InterruptedException e){}
                intersection.takeRoadA();
            }
        }
    }

    public static class TrainB implements Runnable{
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection){
            this.intersection = intersection;
        }

        @Override
        public void run(){
            while(true){
                long sleepingTime = random.nextInt(5);
                try{Thread.sleep(sleepingTime);} catch(InterruptedException e){}
                intersection.takeRoadB();
            }
        }
    }
}

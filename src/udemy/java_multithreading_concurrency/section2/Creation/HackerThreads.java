package udemy.java_multithreading_concurrency.section2.Creation;

import utils.ConsoleColor;

import java.util.Random;

/**
 * Demo of the 'extends' way of implementation
 */
public class HackerThreads
{
    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args)
    {
        Vault vault = new Vault(new Random().nextInt(MAX_PASSWORD));

        new AscendingHackerThread(vault).start();
        new DescendingHackerThread(vault).start();
        new PoliceThread().start();
    }


    private static class Vault
    {
        private int pass;

        public Vault(int pass){
            this.pass = pass;
        }

        public boolean isCorrectPassword(int guess){
            try{
                Thread.sleep(5);
            } catch(InterruptedException e){}
            return this.pass == guess;
        }
    }

    private static abstract class HackerThread extends Thread
    {
        protected Vault vault;

        public HackerThread(Vault vault){
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("... starting thread "+this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread
    {
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run(){
            for(int guess=0; guess<MAX_PASSWORD; guess++){
                if(vault.isCorrectPassword(guess)){
                    System.out.println(ConsoleColor.RED_BOLD+"vault password ("+guess+") cracked by "+this.getName());
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread
    {
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run(){
            for(int guess=MAX_PASSWORD; guess>-1; guess--){
                if(vault.isCorrectPassword(guess)){
                    System.out.println(ConsoleColor.RED_BOLD+"vault password ("+guess+") cracked by "+this.getName());
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread
    {
        @Override
        public void start(){
            System.out.println("Police arriving in ");
            super.start();
        }

        @Override
        public void run(){
            for(int i=10; i>0; i--){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException ie){}
            }
            System.out.println(ConsoleColor.BLUE_BOLD+"Police arrived.");
            System.exit(1);
        }
    }
}

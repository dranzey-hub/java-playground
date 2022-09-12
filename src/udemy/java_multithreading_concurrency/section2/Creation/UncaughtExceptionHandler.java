package udemy.java_multithreading_concurrency.section2.Creation;

public class UncaughtExceptionHandler
{
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {throw new RuntimeException("Intentional Exception");}
        );

        /**
         * used to catch any unchecked exceptions when running our thread
         */
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("error in thread "+t.getName()+": "+e.getMessage());
            }
        });

        thread.start();
    }
}

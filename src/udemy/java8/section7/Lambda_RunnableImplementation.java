package udemy.java8.section7;

public class Lambda_RunnableImplementation {

    public static void main(String[] args) {

        /**
         * Prior to Java 8 (anonymous class):
         */
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("running. i didn't use a lambda for this.");
            }
        };

        new Thread(runnable).start();

        //---

        /**
         * Now, using a lambda function
         */
        Runnable runnable2 = () -> {
            System.out.println("running. i did use a lambda.");
        };

        new Thread(runnable2).start();

        //Or even without braces, when only 1 line in function body
        Runnable runnable3 = () -> System.out.println("running. one liner lambda.");

        new Thread(runnable3).start();
    }
}

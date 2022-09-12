package x.threads;

import java.io.IOException;

public class UserInput
{
    public static void main(String[] args) {
        Thread waitingForInputThread = new Thread(new WaitingForUserInput());

        waitingForInputThread.start();
    }


    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if (input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            }
            ;
        }
    }
}

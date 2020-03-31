package ee.kk.CH3_TimerAndScheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

/**
 * This one is using thing called nested class
 */
public class AnnoyingBeep {

    // Creates a new timer.
    static Toolkit toolkit;
    private static Timer timer = new Timer();
    private static MyTask task = new MyTask();

    // Nested class MyTask
    static class MyTask extends TimerTask {
        private int bigNumber = 10;

        @Override
        //The action to be performed by this timer task.
        public void run() {
            if (bigNumber > 0) {
                toolkit.beep(); // will beep
                System.out.println("Hi, number is still to big " + bigNumber + " ,see you after 10 seconds");
                bigNumber--;
            } else {
                System.out.println("Now it is better:" + bigNumber);
                timer.cancel();
                //System.exit(0);
            }
        }
    }

    public static void main(String[] args){
        toolkit = Toolkit.getDefaultToolkit();
        // This task is scheduled to run every 10 seconds
        timer.scheduleAtFixedRate(task, 0, 10000);
        // cancelling the task and displaying its status
    }
}

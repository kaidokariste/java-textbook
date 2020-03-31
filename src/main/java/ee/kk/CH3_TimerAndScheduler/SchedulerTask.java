package ee.kk.CH3_TimerAndScheduler;

import java.util.TimerTask;

public class SchedulerTask extends TimerTask {
    private int bigNumber = 10;

    @Override
    public void run() {
        if (bigNumber > 0) {
            System.out.println("Hi, number is still to big " + bigNumber + " ,see you after 10 seconds");
            bigNumber--;
        } else {
            System.out.println("Now it is better: " + bigNumber);
            System.exit(0);
        }
    }
}

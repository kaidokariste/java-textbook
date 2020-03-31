package ee.kk.CH3_TimerAndScheduler;

import java.util.Timer;

public class SchedulerMain {
    public static void main(String[] args){

        Timer t = new Timer();
        SchedulerTask mTask = new SchedulerTask();
        // This task is scheduled to run every 10 seconds

        t.scheduleAtFixedRate(mTask, 0, 10000);
    }
}

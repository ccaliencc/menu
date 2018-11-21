package com.warta.Util;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
   private int countdown;
   private boolean canceled;

    public int getCountdown() {
        return countdown;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void countingDown() {

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                if (countdown != 0) {
                    countdown = countdown - 1;

                } else if (countdown == 0)
                    cancel();

            }


            @Override
            public boolean cancel() {
                return canceled = super.cancel();
            }


        }, 0, 1000);
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }
}



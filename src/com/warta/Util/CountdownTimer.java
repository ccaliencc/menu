package com.warta.Util;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    int countdown;

    public CountdownTimer() {
        this.countdown = 10;
    }

    public void countingDown() {


        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.print("\r");
                if (countdown != 0) {
                    System.out.print(countdown);
                    countdown = countdown - 1;

                } else if (countdown == 0)
                    cancel();

            }

            @Override
            public boolean cancel() {
                return super.cancel();
            }

        }, 0, 1000);

    }


    public void setCountdown(String countdown) {
        int num = Integer.parseInt(countdown);
        this.countdown = num;
    }
}



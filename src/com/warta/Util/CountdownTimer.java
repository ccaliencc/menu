package com.warta.Util;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    private int countdown;
    private boolean canceled;
    private boolean blokuj;
    private Timer timer = new Timer();

    public CountdownTimer() {
        this.blokuj = false;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public void setBlokuj(boolean blokuj) {
        this.blokuj = blokuj;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void countingDown() {

        if (!blokuj) {

            getTimer().schedule(new TimerTask() {

                @Override
                public void run() {
                    if (countdown > 0) {

                        countdown -= 1;

                    } else {
                        this.cancel();
                    }

                }


                @Override
                public boolean cancel() {
                    return canceled = super.cancel();
                }


            }, 0, 1000);
        }

    }


}



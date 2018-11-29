package com.warta.Util;

import java.util.ArrayDeque;
import java.util.Timer;
import java.util.TimerTask;

public class TablicaStringow {

    ArrayDeque<String> tablicaZnaki = new ArrayDeque<String>();
    private Timer timer = new Timer();

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    static String horizon = "_";
    static String vertical = "|";
    String joined;
    private boolean blokuj;
    private boolean wpisane;


    public TablicaStringow() {
        this.blokuj = false;
    }

    public void setBlokuj(boolean blokuj) {
        this.blokuj = blokuj;
    }

    public boolean isWpisane() {
        return wpisane;
    }

    public String getJoined() {
        return joined;
    }


    public void testujDzialanie() {
        tablicaZnaki.clear();

        if (!blokuj) {
            for (int i=0; i<4;i++) {
                tablicaZnaki.add(horizon);
            }
            tablicaZnaki.add(vertical);


            getTimer().schedule(new TimerTask() {
                int count = 1;

                @Override
                public void run() {
                    wpisane=false;

                    joined = String.join("", tablicaZnaki);


                    if (count < tablicaZnaki.size()) {
                        String usuniete = tablicaZnaki.remove();
                        tablicaZnaki.add(usuniete);
                    }


                    if (count >= tablicaZnaki.size()) {

                        String usuniete1 = tablicaZnaki.removeLast();
                        String usuniete2 = tablicaZnaki.removeFirst();
                        tablicaZnaki.addFirst(usuniete2);
                        tablicaZnaki.addFirst(usuniete1);

                    }
                    Integer doPetli = (2 * tablicaZnaki.size()) - 2;
                    if (count < doPetli) {
                        count++;
                    } else {
                        count = 1;
                    }
                    wpisane=true;


                }

                @Override
                public boolean cancel() {
                    return super.cancel();
                }

            }, 0, 200);
        }

    }

}

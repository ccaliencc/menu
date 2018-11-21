package com.warta.Util;

import java.util.ArrayDeque;
import java.util.Timer;
import java.util.TimerTask;

public class TablicaStringow {

    ArrayDeque<String> tablicaZnaki = new ArrayDeque<String>();
    static String horizon = "_";
    static String vertical = "|";
    String joined;
    private boolean blokuj;


    public TablicaStringow() {
        this.blokuj = false;
    }

    public void setBlokuj(boolean blokuj) {
        this.blokuj = blokuj;
    }

    public String getJoined() {
        return joined;
    }

    public void testujDzialanie() {
        if (!blokuj) {
            tablicaZnaki.add(horizon);
            tablicaZnaki.add(horizon);
            tablicaZnaki.add(horizon);
            tablicaZnaki.add(horizon);
            tablicaZnaki.add(horizon);
            tablicaZnaki.add(vertical);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int count = 1;


                @Override
                public void run() {

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
                    if (count < (2 * tablicaZnaki.size()) - 2) {
                        count++;
                    } else {
                        count = 1;
                    }


                }

                @Override
                public boolean cancel() {
                    return super.cancel();
                }
            }, 0, 300);
        }

    }

}

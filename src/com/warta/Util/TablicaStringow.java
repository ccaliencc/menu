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

    private static String horizon = "_";
    private static String ball = "o";
    private static String vertical = "|";
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


    public void testujDzialanie(Integer predkosc, Integer dlugoscStolu) {
        tablicaZnaki.clear();

        if (!blokuj) {
            for (int i=0; i<dlugoscStolu+1;i++) {
                tablicaZnaki.add(horizon);
            }
            tablicaZnaki.add(ball);
            tablicaZnaki.addLast(vertical);
            tablicaZnaki.addFirst(vertical);



            getTimer().schedule(new TimerTask() {
                int count = 1;

                @Override
                public void run() {

                    joined = String.join("", tablicaZnaki);

                    if (count < tablicaZnaki.size()-2) {
                        tablicaZnaki.removeFirst();
                        tablicaZnaki.removeLast();
                        String usuniete = tablicaZnaki.remove();
                        tablicaZnaki.add(usuniete);
                        tablicaZnaki.addLast(vertical);
                        tablicaZnaki.addFirst(vertical);

                    }

                    if (count >= tablicaZnaki.size()-2) {

                        tablicaZnaki.removeFirst();
                        tablicaZnaki.removeLast();
                        String usuniete1 = tablicaZnaki.removeLast();
                        String usuniete2 = tablicaZnaki.removeFirst();
                        tablicaZnaki.addFirst(usuniete2);
                        tablicaZnaki.addFirst(usuniete1);
                        tablicaZnaki.addLast(vertical);
                        tablicaZnaki.addFirst(vertical);
                    }


                    Integer doPetli = (2 * (tablicaZnaki.size()-2)) - 2;
                    if (count < doPetli) {
                        count++;
                    } else {
                        count = 1;
                    }


                }

                @Override
                public boolean cancel() {
                    return super.cancel();
                }

            }, 0, predkosc*100); // np 1*100 to predkosc 100 co odpowiada timerowi 100ms
        }

    }

}

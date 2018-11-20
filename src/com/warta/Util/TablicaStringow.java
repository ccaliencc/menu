package com.warta.Util;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class TablicaStringow {

    ArrayDeque<String> tablicaZnaki = new ArrayDeque<String>();
    static String horizon = "_";
    static String vertical = "|";


    public void testujDzialanie() {
        tablicaZnaki.add(horizon);
        tablicaZnaki.add(horizon);
        tablicaZnaki.add(horizon);
        tablicaZnaki.add(horizon);
        tablicaZnaki.add(vertical);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 0;

            @Override
            public void run() {

                System.out.print("\r");
                String joined = String.join("", tablicaZnaki);


                System.out.print(joined);

                if (count < tablicaZnaki.size()) {
                    String usuniete = tablicaZnaki.remove();
                    tablicaZnaki.add(usuniete);
                }


                if (count >= tablicaZnaki.size()) {

                    String usuniete = tablicaZnaki.removeLast();
                    tablicaZnaki.add(usuniete);

                }
                if (count < 2 * tablicaZnaki.size()) {
                    count++;
                } else {
                    count = 0;
                }


            }
        }, 0, 300);


    }

}

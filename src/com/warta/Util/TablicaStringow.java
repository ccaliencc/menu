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
            int count = 1;

            @Override
            public void run() {

                System.out.print("\r");
                String joined = String.join("", tablicaZnaki);


                System.out.print(joined);

                if (count < tablicaZnaki.size()) {
                    String usuniete = tablicaZnaki.remove();
                    tablicaZnaki.add(usuniete);
                }


                if (count > tablicaZnaki.size()) {

                    String usuniete1 = tablicaZnaki.removeLast();
                    String usuniete2 = tablicaZnaki.removeFirst();
                    tablicaZnaki.addFirst(usuniete2);
                    tablicaZnaki.addFirst(usuniete1);

                }
                if (count < 2 * tablicaZnaki.size()) {
                    count++;
                } else {
                    count = 1;
                }


            }
        }, 0, 300);


    }

}

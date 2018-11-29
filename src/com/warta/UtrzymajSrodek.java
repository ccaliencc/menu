package com.warta;

import com.warta.Util.CountdownTimer;
import com.warta.Util.SprawdzanieDanychWE;
import com.warta.Util.TablicaStringow;
import interfaces.UruchamianyProgram;

import java.util.Scanner;
import java.util.Timer;

public class UtrzymajSrodek implements UruchamianyProgram {
    private String nazwaObiektu;
    private String opisFunkcji;

    @Override
    public void setNazwaObiektu(String stworzonaNazwa) {
        this.nazwaObiektu = stworzonaNazwa;
    }

    @Override
    public String getNazwaObiektu() {
        return nazwaObiektu;
    }


    @Override
    public void setOpisFunkcji(String opisFunkcji) {
        this.opisFunkcji = opisFunkcji;
    }


    @Override
    public String getOpisFunkcji() {
        return opisFunkcji;
    }

    @Override
    public void uruchom() {
        Scanner reader = new Scanner(System.in);

        TablicaStringow wyswietlacz = new TablicaStringow();

        SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();
        String numer;
        boolean toNumeric;

        do {
            System.out.print("Wpisz czas do odliczenia lub 'stop' by wyjść  ");
            CountdownTimer countdownTimer = new CountdownTimer();
            numer = reader.next();
            toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);

            if (toNumeric && !numer.equals("stop")) {

                int pozostaloCzasu;
                String joined="";
                int number = Integer.parseInt(numer);
                countdownTimer.setCountdown(number);
                countdownTimer.countingDown();
                Timer timer = new Timer();
                countdownTimer.setTimer(timer);
                Timer timerWyswietlacz = new Timer();
                wyswietlacz.setTimer(timerWyswietlacz);
                wyswietlacz.testujDzialanie();
                countdownTimer.setBlokuj(false);
                wyswietlacz.setBlokuj(false);

                do {

                    System.out.print("\r");

                    pozostaloCzasu = countdownTimer.getCountdown();

                    joined= wyswietlacz.getJoined();

                    System.out.print(pozostaloCzasu + " " + joined);

                }while (!countdownTimer.isCanceled());

                wyswietlacz.getTimer().cancel();

            }


        } while (!numer.equals("stop"));
    }
}

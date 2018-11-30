package com.warta;

import com.warta.Util.CountdownTimer;
import com.warta.Util.SprawdzanieDanychWE;
import com.warta.Util.TablicaStringow;
import interfaces.UruchamianyProgram;

import java.util.Scanner;
import java.util.Timer;

public class PingPong implements UruchamianyProgram {
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
        SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();
        String numer;
        String speed;
        String dlugosc;
        boolean toNumeric;

        do {
            System.out.print("Wpisz czas do odliczenia lub 'stop' by wyjść  ");

            numer = reader.next();
            toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);

            if (toNumeric && !numer.equals("stop")) {
                System.out.print("Wybierz prędkość piłeczki w zakresie 1-5 lub 'b' by cofnąć  ");
                speed = reader.next();
                if(!speed.equals("b")) {
                    toNumeric = sprawdzanieDanychWE.sprawdzNumeric(speed);
                }
                else
                {
                    toNumeric=true;
                }
                if (toNumeric && !speed.equals("b")) {
                    int predkosc = Integer.parseInt(speed);
                    System.out.print("Wybierz długość stołu lub 'b' by cofnąć  ");
                    dlugosc = reader.next();
                    if(!dlugosc.equals("stop")) {
                        toNumeric = sprawdzanieDanychWE.sprawdzNumeric(dlugosc);
                    }
                    else
                    {
                        toNumeric=true;
                    }
                    if (toNumeric && !dlugosc.equals("b")) {
                        int lenght = Integer.parseInt(dlugosc);
                        CountdownTimer countdownTimer = new CountdownTimer();
                        TablicaStringow wyswietlacz = new TablicaStringow();
                        int pozostaloCzasu;
                        String joined = "";
                        int number = Integer.parseInt(numer);
                        countdownTimer.setCountdown(number);
                        Timer timer = new Timer();
                        countdownTimer.setTimer(timer);
                        countdownTimer.countingDown();
                        Timer timerWyswietlacz = new Timer();
                        wyswietlacz.setTimer(timerWyswietlacz);
                        wyswietlacz.testujDzialanie(predkosc, lenght);
                        countdownTimer.setBlokuj(false);
                        wyswietlacz.setBlokuj(false);

                        while (!countdownTimer.isCanceled()) {
                            pozostaloCzasu = countdownTimer.getCountdown() + 1;

                            joined = wyswietlacz.getJoined();

                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {

                            }
                            System.out.print("\r" + pozostaloCzasu + " " + joined);

                        }
                        System.out.print("\r");
                        System.out.print(0 + " " + joined + "\n");

                        wyswietlacz.getTimer().cancel();

                    }
                }
            }


        } while (!numer.equals("stop"));
    }
}

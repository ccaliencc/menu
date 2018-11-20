package com.warta;

import com.warta.Util.SprawdzanieDanychWE;
import interfaces.UruchamianyProgram;
import java.util.Random;
import java.util.Scanner;

public class GeneratorLiczbLosowych implements UruchamianyProgram {

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
    public void uruchom()
    {
        System.out.println(getOpisFunkcji());

        SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();
        Scanner reader = new Scanner(System.in);

        String numer;
        do {
            System.out.print("Wpisz 'losuj' lub 'stop' by wyjść  ");

            numer = reader.next();

            if (numer.equals("losuj") && !numer.equals("stop")) {

                System.out.println("UWAGA UWAGA. LOSUJĘ LICZBĘ");
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                System.out.println("JUŻ BLISKO!");
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }


                int min = 0;
                int max = 1000;
                int losowa = (int)(Math.random()*((max-min)+1))+min;
                System.out.println("Wylosowałeś liczbę: " + losowa);

            }
        }
        while (!numer.equals("stop"));

    }

}

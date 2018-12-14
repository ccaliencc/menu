package com.warta;

import com.warta.Util.SprawdzanieDanychWE;
import interfaces.UruchamianyProgram;

import java.util.Scanner;

public class MegaInkrementator implements UruchamianyProgram {
    private String nazwaObiektu;
    private String opisFunkcji;
    private String lastLine = "";

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
        boolean toNumeric;

        String numer;
        do {
            System.out.print("Wpisz do jakiej wartości ma inkrementować lub 'stop' by wyjść  ");

            numer = reader.next();
            toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);
            if (!numer.equals("stop") && toNumeric) {
                int number = Integer.parseInt(numer);

                for (int i = 0; i < number; i++) {
                    System.out.print("\r");
                    System.out.print("Liczba: " + i);
                }
            }
            System.out.print("\n");
        }
        while (!numer.equals("stop"));

    }
}

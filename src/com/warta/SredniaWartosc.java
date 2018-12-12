package com.warta;
import com.warta.Util.SprawdzanieDanychWE;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SredniaWartosc implements UruchamianyProgram{


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

        List<Double> lista = new ArrayList<>();
        SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();
        Scanner reader = new Scanner(System.in);
        double sum = 0.0;
        double number;
        boolean toNumeric = false;
        String numer;
        do {
            System.out.print("Wpisz liczbę lub 'licz' żeby wyliczyć średnią:  ");

            numer = reader.next();
            if (!numer.equals("licz")) {
                toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);
                if (toNumeric) {
                    number = Double.parseDouble(numer);
                    System.out.println("Wpisałeś liczbę: " + number);

                    lista.add(number);
                }
            }
        }
        while (!numer.equals("licz"));

        for (double num : lista) {
            sum += num;
        }
        double average = sum / lista.size();
        System.out.format("Srednia to: %.2f\n\n", average);
    }

}

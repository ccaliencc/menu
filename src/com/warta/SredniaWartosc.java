package com.warta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SredniaWartosc {

    public void uruchom()
    {
        List<Double> lista = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        double sum = 0.0;
        double number;
        String numer;
        do {
            System.out.print("Wpisz liczbę lub 'end' żeby zakończyć:  ");

            numer = reader.next();

            if (!numer.equals("end")) {
                number = Double.parseDouble(numer);
                System.out.println("Wpisałeś liczbę: " + number);

                lista.add(number);
            }
        }
        while (!numer.equals("end"));

        for (double num : lista) {
            sum += num;
        }
        double average = sum / lista.size();
        System.out.format("Srednia to: %.2f", average);
    }

}

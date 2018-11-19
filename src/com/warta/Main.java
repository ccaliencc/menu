package com.warta;

import com.warta.Util.SprawdzanieDanychWE;
import interfaces.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String numer = "";

        Menu menu = new Menu();
        Inicjalizacja inicjalizacja = new Inicjalizacja();
        SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();

        inicjalizacja.dodajdoMenu(menu);

        menu.wczytajNaglowek();

        do {
            boolean toNumeric = false;

            menu.wczytajMenu();
            numer = reader.next();
            toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);
            if (toNumeric) {
                int wielkoscMenu = menu.getMenu().size() - 1;
                int num = Integer.parseInt(numer);
                if (num > wielkoscMenu) {
                    System.out.println("Wpisz wartość z zakresu 0 - " + wielkoscMenu + "\n");

                } else {
                    menu.getDostepneFunkcje().get(num).uruchom();

                }
            }


        } while (!numer.equals("exit"));


        System.out.println("ZAKOŃCZENIE PROGRAMU. DO ZOBACZENIA!");

    }
}

package com.warta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String numer = "";

        Menu menu = new Menu();
        SredniaWartosc sredniaWartosc = new SredniaWartosc();
        menu.addMenu("Licz wartość średnią", "SredniaWartosc");
        menu.wczytajNaglowek();

        do {
            try {
                menu.wczytajMenu();
                numer = reader.next();
                int wielkoscMenu = menu.getMenu().size() - 1;
                int num = Integer.parseInt(numer);
                if (num > wielkoscMenu) {
                    System.out.println("Wpisz wartość z zakresu 0 - " + wielkoscMenu + "\n");

                } else {
                    menu.getMenuObiektow().get("SredniaWartosc");
                }

            } catch (NumberFormatException e) {
                System.out.println("Wpisz wartość numeryczną\n");
            }


        } while (!numer.equals("exit"));


        System.out.println("ZAKOŃCZENIE PROGRAMU. DO ZOBACZENIA!");

    }
}

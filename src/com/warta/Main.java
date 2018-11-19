package com.warta;
import interfaces.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String numer = "";

        Menu menu = new Menu();

        ArrayList<UruchamianyProgram> dostepneFunkcje = new ArrayList<>();

        UruchamianyProgram sredniaWartosc = new SredniaWartosc();
        dostepneFunkcje.add(sredniaWartosc);
        sredniaWartosc.setOpisFunkcji("Licz Wartość Średnią");


        sredniaWartosc.setNazwaObiektu(sredniaWartosc.getClass().getSimpleName());
        menu.addMenu(sredniaWartosc.getOpisFunkcji(), sredniaWartosc.getClass().getSimpleName());


        menu.wczytajNaglowek();

        do {
            try {
                menu.wczytajMenu();
                numer = reader.next();
                int wielkoscMenu = menu.getMenu().size() - 1;
                int num = Integer.parseInt(numer);
                if (num > wielkoscMenu) {
                    System.out.println("Wpisz wartość z zakresu 0 - " + wielkoscMenu + "\n");

                }
                else {
                    dostepneFunkcje.get(wielkoscMenu).uruchom();

                }

            } catch (NumberFormatException e) {
                System.out.println("Wpisz wartość numeryczną\n");
            }


        } while (!numer.equals("exit"));


        System.out.println("ZAKOŃCZENIE PROGRAMU. DO ZOBACZENIA!");

    }
}

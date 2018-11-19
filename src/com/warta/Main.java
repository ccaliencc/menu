package com.warta;
import interfaces.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String numer = "";

        Menu menu = new Menu();

        UruchamianyProgram sredniaWartosc = new SredniaWartosc();
        sredniaWartosc.setOpisFunkcji("Licz Wartość Średnią");

        sredniaWartosc.setNazwaObiektu(sredniaWartosc.getClass().getSimpleName());
        menu.addMenu(sredniaWartosc.getOpisFunkcji(), sredniaWartosc.getClass().getSimpleName(), sredniaWartosc);


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
                    menu.getDostepneFunkcje().get(num).uruchom();

                }

            } catch (NumberFormatException e) {
                System.out.println("Wpisz wartość numeryczną\n");
            }


        } while (!numer.equals("exit"));


        System.out.println("ZAKOŃCZENIE PROGRAMU. DO ZOBACZENIA!");

    }
}

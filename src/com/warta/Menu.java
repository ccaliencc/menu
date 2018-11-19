package com.warta;

import com.warta.Util.SprawdzanieDanychWE;
import interfaces.UruchamianyProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private ArrayList<String> menu = new ArrayList<>();
    private ArrayList<UruchamianyProgram> dostepneFunkcje = new ArrayList<>();


    public ArrayList<String> getMenu() {
        return menu;
    }


    public ArrayList<UruchamianyProgram> getDostepneFunkcje() {
        return dostepneFunkcje;
    }


    public void addMenu(String opis, UruchamianyProgram obiektDoMenu) {
        this.menu.add(opis);
        this.dostepneFunkcje.add(obiektDoMenu);

    }


    public void wczytajNaglowek() {

        System.out.println("WITAJ W PROGRAMIE JAVA!");
        System.out.println("Żeby wybrać funkcję wpisz numer, żeby wyjść z programu wpisz exit");

    }

    public void wczytajMenu() {


        System.out.println("MENU:");
        for (int i = 0; i < menu.size(); i++)
            System.out.println(i + ": " + menu.get(i));


        System.out.println("\nWybierz funkcję programu :");
    }

    public void wlaczpodprogram() {
        String numer;
        Scanner reader = new Scanner(System.in);
        do {
            boolean toNumeric = false;
            SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();
            this.wczytajMenu();
            numer = reader.next();
            toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);
            if (toNumeric) {
                int wielkoscMenu = this.getMenu().size() - 1;
                int num = Integer.parseInt(numer);
                if (num > wielkoscMenu) {
                    System.out.println("Wpisz wartość z zakresu 0 - " + wielkoscMenu + "\n");

                } else {
                    this.getDostepneFunkcje().get(num).uruchom();

                }
            }

        } while (!numer.equals("exit"));

    }


}

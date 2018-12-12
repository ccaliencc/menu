package com.warta;

import com.warta.Util.SprawdzanieDanychWE;
import interfaces.UruchamianyProgram;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<String> menuList = new ArrayList<>();
    private ArrayList<UruchamianyProgram> dostepneFunkcje = new ArrayList<>();


    public ArrayList<String> getMenuList() {
        return menuList;
    }


    public ArrayList<UruchamianyProgram> getDostepneFunkcje() {
        return dostepneFunkcje;
    }


    public void addMenu(String opis, UruchamianyProgram obiektDoMenu) {
        this.menuList.add(opis);
        this.dostepneFunkcje.add(obiektDoMenu);

    }


    public void wczytajNaglowek() {

        System.out.println("WITAJ W PROGRAMIE JAVA!");
        System.out.println("Żeby wybrać funkcję wpisz numer, żeby wyjść z programu wpisz exit");

    }

    public void wczytajMenu() {


        System.out.println("MENU:");
        for (int i = 0; i < menuList.size(); i++)
            System.out.println(i + ": " + menuList.get(i));


        System.out.println("\nWybierz funkcję programu :");
    }

    public void wlaczpodprogram() {
        String numer;
        Scanner reader = new Scanner(System.in);
        do {
            boolean toNumeric;
            SprawdzanieDanychWE sprawdzanieDanychWE = new SprawdzanieDanychWE();
            this.wczytajMenu();
            numer = reader.next();
            toNumeric = sprawdzanieDanychWE.sprawdzNumeric(numer);
            if (toNumeric) {
                int wielkoscMenu = this.getMenuList().size() - 1;
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

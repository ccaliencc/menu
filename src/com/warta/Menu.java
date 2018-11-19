package com.warta;

import interfaces.UruchamianyProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {

    private HashMap<String, String> menu = new HashMap<>();
    private ArrayList<UruchamianyProgram> dostepneFunkcje = new ArrayList<>();


    public HashMap<String, String> getMenu() {
        return menu;
    }


    public ArrayList<UruchamianyProgram> getDostepneFunkcje() {
        return dostepneFunkcje;
    }



    public void addMenu(String opis, String nazwaKlasy, UruchamianyProgram obiektDoMenu) {
        this.menu.put(opis, nazwaKlasy);
        this.dostepneFunkcje.add(obiektDoMenu);

    }


    public void wczytajNaglowek() {

        System.out.println("WITAJ W PROGRAMIE JAVA!");
        System.out.println("Żeby wybrać funkcję wpisz numer, żeby wyjść z programu wpisz exit");

    }

    public void wczytajMenu() {

        List<String> indexes = new ArrayList<String>(menu.keySet());
        indexes.indexOf(0);
        System.out.println("MENU:");
        for (int i = 0; i < indexes.size(); i++)
            System.out.println(i + ": " + indexes.get(i));


        System.out.println("\nWybierz funkcję programu :");
    }


}

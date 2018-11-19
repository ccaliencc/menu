package com.warta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {

    private HashMap<String, String> menu = new HashMap<>();



    public HashMap<String, String> getMenu() {
        return menu;
    }


    public void addMenu(String opis, String nazwaKlasy) {
        this.menu.put(opis, nazwaKlasy);

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

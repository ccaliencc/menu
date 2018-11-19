package com.warta;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<String> menu = new ArrayList<>();
    private HashMap<String, String> MenuObiektow = new HashMap<>();


    public ArrayList<String> getMenu() {
        return menu;
    }


    public void addMenu(String opis, String nazwaKlasy) {
        this.menu.add(opis);
        this.MenuObiektow.put(opis, nazwaKlasy);
    }

    public HashMap<String, String> getMenuObiektow() {

        return MenuObiektow;
    }

    public void wczytajNaglowek() {

        System.out.println("WITAJ W PROGRAMIE JAVA!");
        System.out.println("Żeby wybrać funkcję wpisz numer, żeby wyjść z programu wpisz exit");

    }

    public void wczytajMenu() {

        System.out.println("MENU:");
        for (int i = 0; i < menu.size(); i++)
            System.out.println(i + ": " + menu.get(0));

        System.out.println("\nWybierz funkcję programu :");
    }


}

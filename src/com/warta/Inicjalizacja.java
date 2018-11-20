package com.warta;

import interfaces.UruchamianyProgram;

import java.util.ArrayList;

public class Inicjalizacja {

    private ArrayList<UruchamianyProgram> dostepneFunkcje = new ArrayList<>();

    private Menu menu = new Menu();

    public Inicjalizacja() {

        UruchamianyProgram sredniaWartosc = new SredniaWartosc();
        sredniaWartosc.setOpisFunkcji("Wylicz Wartość Średnią");
        GeneratorLiczbLosowych generatorLiczbLosowych = new GeneratorLiczbLosowych();
        generatorLiczbLosowych.setOpisFunkcji("Losuj liczbę z przedziału 0 - 1000");
        UtrzymajSrodek utrzymajSrodek = new UtrzymajSrodek();
        utrzymajSrodek.setOpisFunkcji("Utrzymaj znacznik na środku");


        dostepneFunkcje.add(sredniaWartosc);
        dostepneFunkcje.add(generatorLiczbLosowych);
        dostepneFunkcje.add(utrzymajSrodek);

        for (int i = 0; i < dostepneFunkcje.size(); i++)
            menu.addMenu(dostepneFunkcje.get(i).getOpisFunkcji(), dostepneFunkcje.get(i));

        menu.wczytajNaglowek();
    }


    public Menu getMenu() {
        return menu;
    }

}

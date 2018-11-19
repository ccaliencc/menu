package com.warta;

import interfaces.UruchamianyProgram;

import java.util.ArrayList;

public class Inicjalizacja {

    private ArrayList<UruchamianyProgram> dostepneFunkcje = new ArrayList<>();

    public Inicjalizacja() {

        UruchamianyProgram sredniaWartosc = new SredniaWartosc();
        sredniaWartosc.setOpisFunkcji("Licz Wartość Średnią");
        dostepneFunkcje.add(sredniaWartosc);
    }

    public ArrayList<UruchamianyProgram> getDostepneFunkcje() {
        return dostepneFunkcje;
    }

    public void dodajdoMenu(Menu menu)
    {
        for (int i = 0; i<dostepneFunkcje.size(); i++)
        menu.addMenu(dostepneFunkcje.get(i).getOpisFunkcji(), dostepneFunkcje.get(i).getClass().getSimpleName(), dostepneFunkcje.get(i));
    }


}

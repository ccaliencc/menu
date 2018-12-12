package com.warta.Util;

public class SprawdzanieDanychWE {

    public boolean sprawdzNumeric(String Wartosc)
    {
        boolean poprawne=false;
        try {
            Integer.parseInt(Wartosc);
            poprawne=true;

        }
        catch (NumberFormatException e) {
        }

        try {
            Double.parseDouble(Wartosc);
            poprawne=true;

        }
        catch (NumberFormatException e) {
        }

        if (!poprawne)
        {
            System.out.println("Wpisz wartość numeryczną\n");
        }

        return poprawne;
    }

}

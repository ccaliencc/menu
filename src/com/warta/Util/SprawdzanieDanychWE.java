package com.warta.Util;

public class SprawdzanieDanychWE {

    public boolean sprawdzNumeric(String Wartosc)
    {
        boolean poprawne=false;
        try {
            int num = Integer.parseInt(Wartosc);
            poprawne=true;

        }
        catch (NumberFormatException e) {
        }

        try {
            double num = Double.parseDouble(Wartosc);
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

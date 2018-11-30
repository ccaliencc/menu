package com.warta;

import interfaces.UruchamianyProgram;

import java.util.Scanner;

public class Szlaczek implements UruchamianyProgram {
    private String nazwaObiektu;
    private String opisFunkcji;
    private String lastLine = "";

    @Override
    public void setNazwaObiektu(String stworzonaNazwa) {
        this.nazwaObiektu = stworzonaNazwa;
    }

    @Override
    public String getNazwaObiektu() {
        return nazwaObiektu;
    }


    @Override
    public void setOpisFunkcji(String opisFunkcji) {
        this.opisFunkcji = opisFunkcji;
    }


    @Override
    public String getOpisFunkcji() {
        return opisFunkcji;
    }

    @Override
    public void uruchom() {
        Scanner reader = new Scanner(System.in);
        String numer;
        boolean toNumeric;

        do {
            System.out.print("Wpisz 'start' żeby wystartować szlaczek, 'stop' by wyjść  ");

            numer = reader.next();

            if (!numer.equals("stop")) {
                for (int i = 0; i < 20; i++) {
                    animate();

                    try {
                        Thread.sleep(400);
                    }
                    catch (InterruptedException e)
                    {

                    }
                }
                System.out.print("\n");


            }

        } while (!numer.equals("stop"));
    }

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;
    public void animate() {
        switch (anim) {
            case 1:
                print("\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\");
                break;
            case 2:
                print("_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_" );
                break;
            case 3:
                print("/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/");
                break;
            default:
                anim = 0;
                print("\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF\\_/\u00AF");
        }
        anim++;
    }

}

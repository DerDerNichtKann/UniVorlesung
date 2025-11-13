package org.uni;

import org.uni.fahrzeuge.Auto;

public class Main {
    public static final double PREISPROLITER = 2;
    static void main(String[] args) {
        System.out.println("Hello World!");
        IO.println("Hello World!");

        for (int i = 1; i <= 5; i++) {
            IO.println("i = " + i);
        }
        // int ganze zahlen double kommazahlen
        for (int i = 1; i <= 1000; i++) {
            IO.println("Programmieren ist toll! " + i);
        }

        String text = "Hallo Welt";
        // 1 ist inklusive 5 ist exklusive also von Hallo Welt da man von 0 zählt also allo nur.
        // Bei indexof einfach ab wann dieser Buchstaben kommen also ab 1, da es ja nur allo ist.
        String hallo = text.substring(1, 5);
        IO.println(hallo);
        text.substring(1, 5).indexOf("llo");

        KomischeBerechnungen();
        Autostuff();
    }

    private static void Autostuff(){
     /*   ArrayList<Auto> autos = new ArrayList<>();
        autos.add(new Auto("VW", "Grün", 0, 80, 0));
        autos.add(new Auto("Skoda", "Blau", 0, 50, 0));
        IO.println(autos.size());
        IO.println(autos.getFirst().getMaxTank());
        IO.println(autos.getLast().getMarke()); */
        /*
        WENN DER KONSTRUKTOR NUR public Auto(){} ist:
        */
        Auto auto = new Auto();
        auto.setMarke("VW");
        auto.setKilometerstand(0);
        auto.setMaxTank(500);
        auto.setTankstand(400);
        auto.setVerbrauch(4);
        auto.tanken(30.5, PREISPROLITER);
        auto.tanken(40, PREISPROLITER);
        auto.tanken();
        auto.fahre(1000);

        /*
        statt:
        Auto auto1 = new Auto("VW", "Grün", 0, 80, 0);
        Auto auto2 = new Auto("Skoda", "Blau", 0, 50, 0);
        IO.println(auto1.marke);
        IO.println(auto2.maxTank);

        IO.println(Auto.getAnzahlAutos());
         */
    }


    private static void KomischeBerechnungen() {
        Kreisberchnung();
        BMI();
        for (int i = 1; i <= 6; i++) {
            String bewertung = notenBewertung(i);
            IO.println(bewertung);
        }
    /*  notenBewertung(1);
        notenBewertung(2);
        notenBewertung(3);
        notenBewertung(4);
        notenBewertung(5);*/

        summenBerechnung(10, 30);
        quadratZahlenBis(200);
        energieMonitor();
        BenzinPreis();
        PyramidenVolumen();
        StückzahlinAlteMaße(157);
    }

    private static void Kreisberchnung() {
        //konstante mit final (wer hätte das nur gedacht???) immer GROß schreiben
        final double PI = 3.14159;
        double radius = 5.2234653796756793776927939;
        double umfang;
        double fläche;
        umfang = 2 * PI * radius;
        fläche = PI * radius * radius;
        IO.println("Der Kreis mit dem Radius: " + radius + " , hat den Umfang von: "
                + umfang + " LE." + "\n" + "Sowie den Flächeninhalt von: " + fläche + " FE.");
    }

    private static void BMI() {
        double gewichtinKG = 62.34;
        double größeinMeter = 1.865;
        double bmi;

        bmi = gewichtinKG / (größeinMeter * größeinMeter);
        IO.println("Dein BMI Wert beträgt: " + bmi);
    }

    private static String notenBewertung(int note) {
        String bewertung;
        switch (note) {
            case 1:
                bewertung = "Sehr gut";
                break;
            case 2:
                bewertung = "Gut";
                break;
            case 3:
                bewertung = "Befriedigend";
                break;
            case 4:
                bewertung = "Ausreichend";
                break;
            case 5:
                bewertung = "Mangelhaft";
                break;
            default:
                bewertung = "Ungültige Note";

        }
        return bewertung;
    }


   /* private static String notenBewertung(int note) {
        String bewertung = switch (note) {
            case 1 -> "Sehr gut";
            case 2 -> "Gut";
            case 3 -> "Befriedigend";
            case 4 -> "Ausreichend";
            case 5 -> "Mangelhaft";
            default -> "Ungültige Note";
        };
        return bewertung;
    }

    private static String notenBewertung(int note) {
        String bewertung;
        if (note == 1) {
            bewertung = "Sehr gut";
        } else if (note == 2) {
            bewertung = "Gut";
        } else if (note == 3) {
            bewertung = "Befriedigend";
        } else if (note == 4) {
            bewertung = "Ausreichend";
        } else if (note == 5) {
            bewertung = "Mangelhaft";
        } else {
            bewertung = "Ungültige Note";
        }
        return bewertung;
    }*/

    private static void summenBerechnung(int start, int ende) {
        double summe = 0;
        for (int i = start; i <= ende; i++) {
            summe = summe + i;
        }
        IO.println("Die Summe von " + start + " bis " + ende + " ergibt: " + summe);
    }

    private static void quadratZahlenBis(int grenze) {
        int zahl = 1;
        while (zahl * zahl < grenze) {
            IO.println(zahl * zahl);
            zahl++;
        }
    }

    private static void energieMonitor() {
        int energielevel = 100;
        while (energielevel >= 0) {
            if (energielevel >= 70) {
                IO.println("Energie stabil " + energielevel);
            } else if (energielevel >= 30) {
                IO.println("Warnung: Energie sinkt " + energielevel);
            } else if (energielevel > 0) {
                IO.println("Kritusch! Energie fast erschöpft! " + energielevel);
            } else if (energielevel == 0) {
                IO.println("Systeme abgeschaltet " + energielevel);
            }
            energielevel = energielevel - 10;
        }
    }

    private static void BenzinPreis(){
        int getankteLiter = 62;
        double PreisproLiter = 1.459;
        double Betrag;
        Betrag = getankteLiter * PreisproLiter;
        IO.println("Brutto Betrag beträgt: " + Betrag);
        double Nettobetrag;
        Nettobetrag = Betrag * 100 / 119;
        IO.println("Der Netto Betrag beträgt: " + Nettobetrag);
    }

    private static void PyramidenVolumen() {
        double h = 280;
        double g = 440 * 440;
        double VolumenEllen3 = (1.0 / 3.0) * g * h;
        double meterProElle = 0.5236;
        double m3ProRoemischerScheffel = 0.00873;
        double m3ProElle3 = Math.pow(meterProElle, 3);
        double Meterhoch3 = VolumenEllen3 * m3ProElle3;

        double römischeScheffel = Meterhoch3 / m3ProRoemischerScheffel;

        IO.println("Das Volumen beträgt " + VolumenEllen3 + " Ellen hoch 3, das entspricht " + Meterhoch3 + " m3.");
        IO.println("Das Volumen beträgt " + VolumenEllen3 + " Ellen hoch 3, das entspricht " + römischeScheffel + " römischen Scheffeln.");

        double anzahlBloecke = VolumenEllen3 / 8;

        IO.println("Dafür werden etwa " + anzahlBloecke + " Sandsteinblöcke (a 8 Ellen³) benötigt.");
    }

    private static void StückzahlinAlteMaße(int Stücke) {
        int originalStücke = Stücke;
        int gros = Stücke / 144;
        Stücke = Stücke % 144;
        int schock = Stücke / 60;
        Stücke = Stücke % 60;
        int dutzend = Stücke / 12;
        int restStück = Stücke % 12;
        IO.println(originalStücke + " N sind " + gros + " Gros, " + schock + " Schock, " + dutzend + " Dutzend und " + restStück + " Stück.");
    }
}


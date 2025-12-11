package org.uni.fahrzeuge;

public class Motorad extends Fahrzeuge implements Waschbar{
    boolean hatBeiwagen;
    boolean hatKettenantrieb;
    String kategorie;
    public Motorad(String marke, String farbe, float tankstand, float maxTank, float kilometerstand, double hubraum, boolean hatBeiwagen, boolean hatKettenantrieb, String kategorie){
        super(marke, farbe, tankstand, maxTank, kilometerstand, hubraum);
        this.hatBeiwagen = hatBeiwagen;
        this.hatKettenantrieb = hatKettenantrieb;
        this.kategorie = kategorie;
    }

    @Override
    public boolean waschbar(double liter){
        return false;
    }

    public void hupen() {
        IO.println("Das Motorrad hupt.");
    }

    @Override
    public double berechneVersicherung(int fahrerAlter) {
        double preis = 400.0;

        if (fahrerAlter < 25) {
            preis += 300.0;
        } else if (fahrerAlter >= 40) {
            preis -= 50.0;
        }

        return preis;
    }
}

package org.uni.fahrzeuge;

public class Motorad extends Fahrzeuge{
    boolean hatBeiwagen;
    boolean hatKettenantrieb;
    String kategorie;
    public Motorad(String marke, String farbe, float tankstand, float maxTank, float kilometerstand, double hubraum, boolean hatBeiwagen, boolean hatKettenantrieb, String kategorie){
        super(marke, farbe, tankstand, maxTank, kilometerstand, hubraum);
        this.hatBeiwagen = hatBeiwagen;
        this.hatKettenantrieb = hatKettenantrieb;
        this.kategorie = kategorie;
    }
}

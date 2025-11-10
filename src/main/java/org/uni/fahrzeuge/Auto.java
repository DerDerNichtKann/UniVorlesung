package org.uni.fahrzeuge;

import lombok.Getter;

import java.awt.*;

public class Auto {
    public String marke;
    public String farbe;
    public float tankstand;
    public float maxTank;
    public float kilometerstand;
    @Getter
    public static int anzahlAutos;

    public Auto(String marke, String farbe, float tankstand, float maxTank, float kilometerstand) {
        this.marke = marke;
        this.farbe = farbe;
        this.tankstand = tankstand;
        this.kilometerstand = kilometerstand;
        this.maxTank = maxTank;
        //theorethish hat noch:
        //tankstand = 0;
        //kilometerstand = 0;
        anzahlAutos++;
    }
}

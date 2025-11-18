package org.uni.fahrzeuge;

import lombok.Getter;
import lombok.Setter;
import org.uni.Main;

import java.util.ArrayList;

public class Auto extends Fahrzeuge{
    @Getter
    public static int anzahlAutos;

    // Konstante für die Klasse private static final int KONSTANTE = 10;

    //Konstruktor
    public Auto(String marke, String farbe, float tankstand, float maxTank, float kilometerstand, double hubraum) {
        super(marke, farbe, tankstand, kilometerstand, maxTank, hubraum);
        anzahlAutos++;
    }


    /*public Auto(){
    }*/


    /*
    Statt @Getter @Setter
    public String getMarke(){
        return marke;
    }
    public void setMarke(String marke){
        this.marke = marke;
    }
     */
}

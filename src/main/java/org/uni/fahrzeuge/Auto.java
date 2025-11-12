package org.uni.fahrzeuge;

import lombok.Getter;
import lombok.Setter;
import org.uni.Main;

public class Auto {
    @Getter
    @Setter
    private String marke;
    @Getter
    @Setter
    private String farbe;
    @Getter
    @Setter
    private float tankstand;
    @Getter
    @Setter
    private float maxTank;
    @Getter
    @Setter
    private float kilometerstand;
    @Getter
    @Setter
    private float verbrauch;
    @Getter
    private static int anzahlAutos;

    // Konstante für die Klasse private static final int KONSTANTE = 10;

    //Konstruktor
   /* public Auto(String marke, String farbe, float tankstand, float maxTank, float kilometerstand) {
        this.marke = marke;
        this.farbe = farbe;
        this.tankstand = tankstand;
        this.kilometerstand = kilometerstand;
        this.maxTank = maxTank;
        //theoretisch halt, wenn wir wollen das es immer 0 gibt:
        //tankstand = 0;
        //kilometerstand = 0;
        anzahlAutos++;
    }*/


    public Auto(){
    }


    /*
    Statt @Getter @Setter
    public String getMarke(){
        return marke;
    }
    public void setMarke(String marke){
        this.marke = marke;
    }
     */

    public boolean istleer(){
        return tankstand == 0;
    }

    public void fahre(float kilometer){
       double kraftstoffverbrauchliter = kilometer * verbrauch;
       double gefahrenbistankalleinkm = 0;
       if (kraftstoffverbrauchliter <= tankstand){
           tankstand = (float) (tankstand - kraftstoffverbrauchliter);
           kilometerstand =+ kilometer;
           IO.println("Das Auto ist " + kilometer + "km gefahren und hat noch einen Tankstand von: " + tankstand + "L.");
       } else {
           while (!istleer()){
              gefahrenbistankalleinkm = gefahrenbistankalleinkm + 1;
              kilometerstand = kilometerstand+ 1;
              tankstand = tankstand - verbrauch;
           }
           IO.println("Tank ist leer nach " + gefahrenbistankalleinkm +  "km. Dein Kilometerstand beträgt: "+ kilometerstand);
       }
    }

    public double tanken(){
        double zubetanken = maxTank - tankstand;
        tankstand = maxTank;
        double preis = zubetanken * Main.PREISPROLITER;
        IO.println(preis);
        return preis;
    }

}

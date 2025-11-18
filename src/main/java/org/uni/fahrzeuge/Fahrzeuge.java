package org.uni.fahrzeuge;

import lombok.Getter;
import lombok.Setter;
import org.uni.Main;

import java.util.ArrayList;

public class Fahrzeuge {
    @Getter
    @Setter
    public String marke;
    @Getter
    @Setter
    public String farbe;
    @Getter
    @Setter
    public static float tankstand;
    @Getter
    @Setter
    public static float maxTank;
    @Getter
    @Setter
    public float kilometerstand;
    @Getter
    @Setter
    public float verbrauch;
    @Getter
    @Setter
    public double hubraum;

    public Fahrzeuge(String marke, String farbe, float tankstand, float maxTank, float kilometerstand, double hubraum) {
        this.marke = marke;
        this.farbe = farbe;
        Fahrzeuge.tankstand = tankstand;
        this.kilometerstand = kilometerstand;
        Fahrzeuge.maxTank = maxTank;
        this.hubraum = hubraum;
    }

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
        IO.println("Du musst " + preis + "€ zahlen und das für " + zubetanken + " Liter.");
        return preis;
    }

    public static double tankenohneprint(){
        double zubetanken = maxTank - tankstand;
        tankstand = maxTank;
        return zubetanken * Main.PREISPROLITER;
    }

    public static void AlleAutosTanken(ArrayList<Auto> autos){
        double gesamtpreis = 0;
        for (Auto auto : autos){
            gesamtpreis = gesamtpreis + tankenohneprint();
        }
        IO.println("Das Tanken aller " + autos.size() + " Autos, hat " + String.format("%.2f", gesamtpreis) + "€ gekostet." );
    }


    public double tanken(double liter, double preisProLiter){
        double tankmenge = liter + tankstand;
        double zuzahlen = 0;
        if (tankmenge <= maxTank){
            zuzahlen = liter * preisProLiter;
            tankstand = (float) tankmenge;
            IO.println("Du musst " + zuzahlen + "€ zahlen, für " + liter + " Liter.");
        } else {
            double zuviel = tankmenge - maxTank;
            liter = liter - zuviel;
            zuzahlen = liter * preisProLiter;
            tankstand = maxTank;
            IO.println("Du musst " + zuzahlen + "€ zahlen, du hast " + liter + " Liter getankt.");
        }
        return zuzahlen;
    }

    public double tanken(int euroMax, double preisProLiter){
        double zutanken = euroMax / preisProLiter;
        double theortischertank = tankstand + zutanken;
        if (theortischertank <= maxTank){
            tankstand = (float) (zutanken + tankstand);
            IO.println("Du hast für " + euroMax + "€ getankt. Das sind " + zutanken + " Liter.");
        } else {
            double zuviel = theortischertank - maxTank;
            zutanken = zutanken - zuviel;
            double preis = zutanken * preisProLiter;
            tankstand = maxTank;
            double übrig = euroMax - preis;
            IO.println("Du hast für " + preis + "€ getankt. Das sind " + zutanken + " Liter. Du bekommst " + übrig + "€ zurück.");
        }
        return zutanken;
    }

}

package org.uni.bibliothek;

public class DVD extends Medium{

    int laufzeit;
    int fsk;

    public DVD(String id, String titel, int erscheinungsjahr, int laufzeit, int fsk) {
        super(id, titel, erscheinungsjahr);
        this.fsk = fsk;
        this.laufzeit = laufzeit;
    }

    @Override
    public double berechneLeihgebuehr() {
        return 1.50;
    }
}

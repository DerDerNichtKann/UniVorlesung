package org.uni.bibliothek;

public class Magazine extends Medium{

    public Magazine(String id, String titel, int erscheinungsjahr) {
        super(id, titel, erscheinungsjahr);
    }

    @Override
    public double berechneLeihgebuehr() {
        return 1.00;
    }
}

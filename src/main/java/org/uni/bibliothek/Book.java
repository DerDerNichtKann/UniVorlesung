package org.uni.bibliothek;

public class Book extends Medium{

    String autor;
    int seiten;

    public Book(String id, String titel, int jahr, String autor, int seiten){
        super(id, titel, jahr);
        this.autor = autor;
        this. seiten = seiten;
    }

    @Override
    public double berechneLeihgebuehr() {
        return 0.50;
    }
}

package org.uni.bibliothek;

public class Loan {
    private Medium medium;
    private String benutzerName;
    private String ausleihDatum;
    private String rueckgabeDatum;
    private String tatsaechlichesRueckgabeDatum;

    public Loan(Medium medium, String benutzerName, String ausleihDatum, String rueckgabeDatum) {
        this.medium = medium;
        this.benutzerName = benutzerName;
        this.ausleihDatum = ausleihDatum;
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public double berechneGesamtgebuehr(int ausgelieheneTage) {
        return medium.berechneLeihgebuehr() * ausgelieheneTage;
    }

    public Medium getMedium() {
        return medium;
    }

    public String getBenutzerName() {
        return benutzerName;
    }
}
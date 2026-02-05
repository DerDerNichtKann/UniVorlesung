package org.uni.bibliothek;

public abstract class Medium {
    private String id;
    private String titel;
    private int erscheinungsjahr;
    private boolean istAusgeliehen;

    public Medium(String id, String titel, int erscheinungsjahr) {
        this.id = id;
        this.titel = titel;
        this.erscheinungsjahr = erscheinungsjahr;
        this.istAusgeliehen = false;
    }

    public String getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public boolean istVerfügbar() {
        return !istAusgeliehen;
    }

    public void setVerfuegbar(boolean status) {
        this.istAusgeliehen = !status;
    }

    public abstract double berechneLeihgebuehr();

}

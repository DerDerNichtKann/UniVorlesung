package org.uni.bibliothek;

public class ReferenceBook extends Book implements NurPraesenz{

    String fachgebiet;

    public ReferenceBook(String fachgebiet, String id, String titel, int jahr, String autor, int seiten){
        super(id,titel,jahr,autor,seiten);
        this.fachgebiet = fachgebiet;
    }

    public String getFachgebiet() {
        return fachgebiet;
    }

    @Override
    public String getPraesenzgrund() {
        return "Dieses Buch ist ein Präsenzexemplar im Fachgebiet " + fachgebiet;
    }
}

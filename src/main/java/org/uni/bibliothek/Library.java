package org.uni.bibliothek;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Medium> medienListe;
    private List<Loan> ausleihListe;

    public Library() {
        this.medienListe = new ArrayList<>();
        this.ausleihListe = new ArrayList<>();
    }

    public void addMedium(Medium m) {
        medienListe.add(m);
    }

    public Medium findMediumById(String id) {
        for (Medium m : medienListe) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public void removeMedium(String id) {
        Medium m = findMediumById(id);
        if (m != null) {
            medienListe.remove(m);
        }
    }

    public Loan ausleihen(String mediumId, String benutzer, String datum, String rueckgabe) {
        Medium medium = findMediumById(mediumId);
        if (medium == null) {
           IO.println("Fehler: Medium nicht gefunden.");
            return null;
        }

        if (!medium.istVerfügbar()) {
           IO.println("Fehler: Medium ist bereits ausgeliehen.");
            return null;
        }

        if (medium instanceof NurPraesenz) {
            NurPraesenz np = (NurPraesenz) medium;
            IO.println("Fehler: Nicht ausleihbar. Grund: " + np.getPraesenzgrund());
            return null;
        }

        Loan loan = new Loan(medium, benutzer, datum, rueckgabe);
        ausleihListe.add(loan);
        medium.setVerfuegbar(false);
        IO.println("Erfolg: Medium '" + medium.getTitel() + "' wurde an " + benutzer + " ausgeliehen.");
        return loan;
    }
}
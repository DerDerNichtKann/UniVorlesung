package org.uni.personal;

public class MitarbeiterStatistik {

    public static double berechneDurchschnittsGehalt(Mitarbeiter[] liste) {
        if (liste == null || liste.length == 0) return 0.0;
        double summe = 0;
        int anzahl = 0;
        for (Mitarbeiter m : liste) {
            if (m != null) {
                summe += m.getGehalt();
                anzahl++;
            }
        }
        return (anzahl > 0) ? (summe / anzahl) : 0.0;
    }

    public static Manager findeManagerMitHoechstemBonus(Manager[] liste) {
        if (liste == null || liste.length == 0) return null;
        Manager maxManager = null;
        double maxBonus = -1.0;
        for (Manager m : liste) {
            if (m != null && m.getBonus() > maxBonus) {
                maxBonus = m.getBonus();
                maxManager = m;
            }
        }
        return maxManager;
    }

    public static Stundenloehner[] findeTeilzeitkraefte(Stundenloehner[] liste) {
        if (liste == null) return new Stundenloehner[0];
        int count = 0;
        for (Stundenloehner s : liste) {
            if (s != null && !s.istVollzeit()) count++;
        }
        Stundenloehner[] ergebnis = new Stundenloehner[count];
        int index = 0;
        for (Stundenloehner s : liste) {
            if (s != null && !s.istVollzeit()) {
                ergebnis[index++] = s;
            }
        }
        return ergebnis;
    }
}
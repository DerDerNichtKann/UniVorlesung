package org.uni.personal;

import lombok.Getter;

public class Manager extends Mitarbeiter {
    private double grundgehalt;
    @Getter
    private double bonus;

    public Manager(int mitarbeiterNr, String name, double grundgehalt, double bonus) {
        super(mitarbeiterNr, name, 0, "Manager");
        this.grundgehalt = grundgehalt;
        this.bonus = bonus;
        aktualisiereGehalt();
    }

    private void aktualisiereGehalt() {
        this.gehalt = this.grundgehalt + this.bonus;
    }

    @Override
    public void anzeigen() {
        super.anzeigen();
        IO.println("  -> Detail: Grundgehalt: " + grundgehalt + ", Bonus: " + bonus);
        IO.println("  -> Bonuskategorie: " + bonusKategorie());
    }

    public String bonusKategorie() {
        if (bonus < 1000) return "kleiner Bonus";
        if (bonus <= 3000) return "normaler Bonus";
        return "sehr hoher Bonus";
    }

    @Override
    public String getJobInfo() {
        return "Manager (Bonus: " + this.bonus + " EUR)";
    }

}
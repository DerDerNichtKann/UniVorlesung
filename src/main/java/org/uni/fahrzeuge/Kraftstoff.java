package org.uni.fahrzeuge;

import lombok.Getter;

public enum Kraftstoff {
    BENZIN(1.79),
    DIESEL(1.65),
    GAS(0.99);

    private final double preisProLiter;

    Kraftstoff(double preisProLiter) {
        this.preisProLiter = preisProLiter;
    }

    public double getPreisProLiter() {
        return this.preisProLiter;
    }
}

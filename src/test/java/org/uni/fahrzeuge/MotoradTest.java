package org.uni.fahrzeuge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotoradTest {

    @Test
    void testBerechneVersicherungMotorrad() {
        Motorad bike = new Motorad("Suzuki", "Gelb", 10, 20, 0, 600, false, true, "Sport");

        assertEquals(400.0, bike.berechneVersicherung(30));
    }

    @Test
    void testWaschbarMotorrad() {
        Motorad bike = new Motorad("Suzuki", "Gelb", 10, 20, 0, 600, false, true, "Sport");
        assertFalse(bike.waschbar(5.0), "Motorräder sollten laut Interface-Implementierung nicht waschbar sein.");
    }
}
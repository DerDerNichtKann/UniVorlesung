package org.uni.fahrzeuge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutoTest {
    @Test
    void testBerechneVersicherungAuto() {
        Auto auto = new Auto("warum", "tue", 10, 12, 12, 12);
        assertEquals(800, auto.berechneVersicherung(18));
    }

    @Test
    void testWaschbarAuto() {
        Auto auto = new Auto("warum", "tue", 10, 12, 12, 12);
        assertTrue(auto.waschbar(5.0));
    }
}

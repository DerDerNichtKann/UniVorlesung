package org.uni.bibliothek;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AusleiheTests {

    @Test
    void berechneGesamtgebuehrt(){
        DVD dvd = new DVD("D001", "Action Film", 2019, 120, 16);
        Loan loan = new Loan(dvd, "Max", "2023-01-01", "2023-01-10");

        double gebuehr = loan.berechneGesamtgebuehr(10);

        assertEquals(15.00, gebuehr, 0.001);

        Book buch = new Book("B100", "Günstig", 2000, "A", 100);
        Loan loanBuch = new Loan(buch, "Moritz", "2023-01-01", "2023-01-05");

        assertEquals(2.50, loanBuch.berechneGesamtgebuehr(5), 0.001);
    }
}
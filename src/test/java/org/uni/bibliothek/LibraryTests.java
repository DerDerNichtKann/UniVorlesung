package org.uni.bibliothek;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTests {

    @Test
    void addMediumTest(){
        Library lib = new Library();
        Book buch = new Book("B001", "Testbuch", 2020, "Autor", 200);
        lib.addMedium(buch);
        assertNotNull(lib.findMediumById("B001"));
    }

    @Test
    void findMediumByIdTest(){
        Library lib = new Library();
        Book buch = new Book("B002", "Suche Mich", 2021, "Autor", 150);

        lib.addMedium(buch);

        Medium gefunden = lib.findMediumById("B002");
        assertNotNull(gefunden);

        assertEquals("Suche Mich", gefunden.getTitel());

        Medium nichtGefunden = lib.findMediumById("XYZ");
        assertNull(nichtGefunden);
    }

    @Test
    void erfolgreicheAusleiheTest(){
        Library lib = new Library();
        Book buch = new Book("B003", "Ausleihbar", 2022, "Autor", 300);

        lib.addMedium(buch);
        assertTrue(buch.istVerfügbar());

        Loan loan = lib.ausleihen("B003", "Student User", "2023-11-01", "2023-11-14");

        assertNotNull(loan);
        assertEquals("Student User", loan.getBenutzerName());
        assertFalse(buch.istVerfügbar());
    }
}
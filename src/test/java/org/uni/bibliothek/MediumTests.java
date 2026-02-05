package org.uni.bibliothek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MediumTests {
    @Test
    void brechneLeihgebuehrtest(){
        Book book = new Book("B001", "Java Basics", 2020, "Max Muster", 350);
        assertEquals(0.50, book.berechneLeihgebuehr());
        DVD dvd = new DVD("B001", "Java Basics", 2020, 12, 350);
        assertEquals(1.5, dvd.berechneLeihgebuehr());
        Magazine magazine = new Magazine("B001", "Java Basics", 2020);
        assertEquals(1, magazine.berechneLeihgebuehr());
    }

}

package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    Courier courier = new Courier();

    @BeforeEach
    void init() {
        courier.addRide(new Ride(1, 1, 12));
        courier.addRide(new Ride(2, 3, 12));
        courier.addRide(new Ride(5, 6, 12));
    }


    @Test
    void testAddRide() {
        assertEquals(3, courier.getRides().size());
        assertEquals(5, courier.getRides().get(2).getDayOfWeek());
        assertEquals(6, courier.getRides().get(2).getNumberOfRide());
        assertEquals(12, courier.getRides().get(2).getKm());
    }

    @Test
    void testAddRideWithInvalidDay() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(new Ride(2, 3, 12)));
        assertEquals("Nap nem lehet kisebb, mint az utolsó.", exception.getMessage());
    }

    @Test
    void testAddRideWithInvalidNumberOfRide() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(new Ride(5, 5, 12)));
        assertEquals("Sorszám lehet kisebb, mint az utolsó.", exception.getMessage());
    }
}
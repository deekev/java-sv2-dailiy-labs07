package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testCreateWithValidDatas() {
        Human human = new Human("John Doe", 1901);
        assertEquals("John Doe", human.getName());
        assertEquals(1901, human.getYearOfBirth());
    }

    @Test
    void testCreateWithInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human("Joe", 1975));
        assertEquals("Invalid name: Joe", exception.getMessage());
    }

    @Test
    void testCreateWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human(null, 1975));
        assertEquals("Invalid name: null", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidYearOfBirth() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe", 1900));
        assertEquals("Invalid year of birth: 1900", exception.getMessage());
    }
}
package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {

    @Test
    void testCrateCourierByFile(){
        Path path = Paths.get("src/test/resources/rides.txt");
        CourierFileManager courierFileManager = new CourierFileManager();
        Courier courier = courierFileManager.crateCourierByFile(path);

        assertEquals(6, courier.getRides().size());
        assertEquals(4, courier.getRides().get(5).getDayOfWeek());
        assertEquals(3, courier.getRides().get(5).getNumberOfRide());
        assertEquals(9, courier.getRides().get(5).getKm());
    }
}
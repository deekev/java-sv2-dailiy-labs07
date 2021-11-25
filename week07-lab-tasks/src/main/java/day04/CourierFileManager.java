package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CourierFileManager {

    public Courier crateCourierByFile(Path path) {
        List<String> rides;
        try {
            rides = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("File nem található", ioe);
        }

        Courier courier = new Courier();
        for (String s: rides) {
            String[] temp = s.split(" ");
            Ride ride = new Ride(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
            courier.addRide(ride);
        }
        return courier;
    }
}

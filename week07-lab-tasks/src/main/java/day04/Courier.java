package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (rides.size() > 0) {
            Ride ridesLast = rides.get(rides.size() - 1);
            if (ride.getDayOfWeek() < ridesLast.getDayOfWeek()) {
                throw new IllegalArgumentException("Nap nem lehet kisebb, mint az utolsó.");
            }
            if (ride.getDayOfWeek() == ridesLast.getDayOfWeek() && ride.getNumberOfRide() <= ridesLast.getNumberOfRide()) {
                throw new IllegalArgumentException("Sorszám nagyobb legyen, mint az utolsó.");
            }
        }
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }
}
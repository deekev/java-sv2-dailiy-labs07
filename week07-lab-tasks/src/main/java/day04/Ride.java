package day04;

public class Ride {

    private int dayOfWeek;
    private int numberOfRide;
    private int km;

    public Ride(int dayOfWeek, int numberOfRide, int km) {
        this.dayOfWeek = dayOfWeek;
        this.numberOfRide = numberOfRide;
        this.km = km;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public int getKm() {
        return km;
    }
}

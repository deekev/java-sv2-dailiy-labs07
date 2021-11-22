package day01;

import java.time.LocalDate;

public class Human {

    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (isNameValid(name) && isYearOfBirthValid(yearOfBirth)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    private boolean isNameValid(String name) {
        if (name == null || name.indexOf(" ") == 0) {
            throw new IllegalArgumentException("Invalid name: " + name);
        } else {
            return true;
        }
    }

    private boolean isYearOfBirthValid(int yearOfBirth) {
        int year = LocalDate.now().getYear();
        if (year - yearOfBirth > 120) {
            throw new IllegalArgumentException("Invalid year of birth: " + yearOfBirth);
        } else {
            return true;
        }
    }
}
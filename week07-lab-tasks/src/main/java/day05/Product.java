package day05;

import java.time.LocalDate;

public class Product {

    private String name;
    private LocalDate dateOfSale;
    private int price;

    public Product(String name, LocalDate dateOfSale, int price) {
        this.name = name;
        this.dateOfSale = dateOfSale;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ";" + dateOfSale + ";" + price;
    }
}
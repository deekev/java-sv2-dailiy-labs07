package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        if (p == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }
        if (p.getDateOfSale().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date.");
        }
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void writeProductsByMonth(Month month, Path path) {
        List<String> productsByMonth = createStringListByMonth(month);
        try {
            Files.write(path, productsByMonth);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write file.", ioe);
        }
    }

    private List<String> createStringListByMonth(Month month) {
        List<String> productsByMonth = new ArrayList<>();
        for (Product p: products) {
            if (p.getDateOfSale().getMonth().equals(month)) {
                productsByMonth.add(p.toString());
            }
        }
        return productsByMonth;
    }
}
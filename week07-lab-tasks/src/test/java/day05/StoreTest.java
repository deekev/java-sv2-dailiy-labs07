package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store = new Store();

    @BeforeEach
    void init() {
        store.addProduct(new Product("t-shirt", LocalDate.of(2021,10,10), 2300));
        store.addProduct(new Product("t-shirt", LocalDate.of(2021,11,15), 2000));
        store.addProduct(new Product("t-shirt", LocalDate.of(2021,10,12), 3500));
    }

    @TempDir
    File temporaryFolder;

    @Test
    void writeProductsByMonth() throws IOException {
        Path path = temporaryFolder.toPath().resolve("result.txt");
        store.writeProductsByMonth(Month.OCTOBER, path);
        List<String> result = Files.readAllLines(path);

        assertEquals("t-shirt;2021-10-12;3500", result.get(1));
        assertEquals("t-shirt;2021-10-10;2300", result.get(0));
        assertEquals(2, result.size());
    }
}
package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void testFillMovies() {
        Path path = Paths.get("src/test/resources/movies.csv");
        MovieService movieService = new MovieService(path);

        assertEquals(5, movieService.getMovies().size());
        assertEquals("James Cameron", movieService.getMovies().get(1).getDirector());
    }

    @Test
    void testFillMoviesNotFound() {
        Path path = Paths.get("src/test/resources/movies_csv");

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> new MovieService(path));
        assertEquals("Can not read file.", exception.getMessage());
        assertEquals(NoSuchFileException.class, exception.getCause().getClass());
    }
}
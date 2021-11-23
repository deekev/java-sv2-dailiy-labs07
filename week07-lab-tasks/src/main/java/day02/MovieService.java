package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            fillListWithMovies(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    private void fillListWithMovies(List<String> lines) {
        for (String actual: lines) {
            String[] temp = actual.split(";");
            movies.add(new Movie(temp[0], Integer.parseInt(temp[1]), temp[2]));
        }
    }
}
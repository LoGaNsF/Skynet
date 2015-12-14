package es.jmgarrido.skynet.Services;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import es.jmgarrido.skynet.Models.Movie;

public class MovieDAO {

    static List<Movie> listMovies = new LinkedList<Movie>();

    public void save(List<Movie> movies) {
        listMovies.clear();
        listMovies.addAll(movies);
    }

    public Movie getMovieById(int id) {
        return listMovies.get(id);
    }

    public Collection<Movie> list(List<Movie> movies) {
        return Collections.unmodifiableCollection(movies);
    }

}

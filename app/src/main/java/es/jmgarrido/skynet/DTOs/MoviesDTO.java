package es.jmgarrido.skynet.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviesDTO {

    @JsonProperty(value="results")
    private List<MovieDTO> movies;

    public MoviesDTO() {}


    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}

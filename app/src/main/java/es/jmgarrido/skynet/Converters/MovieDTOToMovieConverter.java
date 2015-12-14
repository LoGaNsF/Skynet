package es.jmgarrido.skynet.Converters;

import es.jmgarrido.skynet.DTOs.MovieDTO;
import es.jmgarrido.skynet.Models.Movie;

public class MovieDTOToMovieConverter {

    public Movie converter(MovieDTO movieDTO) {
        Movie movie = new Movie();

        movie.setTitle(movieDTO.getTitle());
        movie.setYear(movieDTO.getYear());
        movie.setDescription(movieDTO.getDescription());
        movie.setPoster(movieDTO.getImage());

        return movie;
    }

}

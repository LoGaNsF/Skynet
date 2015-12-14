package es.jmgarrido.skynet.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private String title;

    private String year;

    private String description;

    private String poster;

    public Movie() {}

    public Movie(String title, String year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return "https://image.tmdb.org/t/p/w185" + poster;
    }

    public void setPoster(String image) {
        this.poster = image;
    }
}

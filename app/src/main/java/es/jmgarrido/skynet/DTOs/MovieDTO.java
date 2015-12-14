package es.jmgarrido.skynet.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDTO {

    @JsonProperty(value="original_title")
    private String title;

    @JsonProperty(value="release_date")
    private String year;

    @JsonProperty(value="overview")
    private String description;

    @JsonProperty(value="poster_path")
    private String poster;

    public MovieDTO() {}


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

    public String getImage() {
        return poster;
    }

    public void setImage(String image) {
        this.poster = image;
    }
}

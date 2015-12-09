package es.jmgarrido.skynet.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty(value="original_title")
    private String title;

    @JsonProperty(value="release_date")
    private String year;

    @JsonProperty(value="overview")
    private String description;

    public Item(String title, String year, String description) {
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
}

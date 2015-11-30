package es.jmgarrido.skynet.Models;

public class Item {

    private String title;
    private int year;
    private String description;

    public Item(String title, int year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }
}

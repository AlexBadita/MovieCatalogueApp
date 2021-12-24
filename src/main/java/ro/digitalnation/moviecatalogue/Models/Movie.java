package ro.digitalnation.moviecatalogue.Models;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie extends CatalogueEntry {

    private Integer duration;

    public Movie() {}

    public Movie(Integer duration) {
        this.duration = duration;
    }

    public Movie(String name, Integer releaseYear, Genre genre, Language language, String about, Integer duration) {
        super(name, releaseYear, genre, language, about);
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}

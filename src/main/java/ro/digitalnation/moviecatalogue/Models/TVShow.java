package ro.digitalnation.moviecatalogue.Models;

import javax.persistence.*;

@Entity
@Table(name = "TVShow")
public class TVShow extends CatalogueEntry {

    private Integer seasons;

    private Integer episodes;

    public TVShow() {}

    public TVShow(Integer seasons, Integer episodes) {
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public TVShow(String name, Integer releaseYear, Genre genre, Language language, String about, Integer seasons, Integer episodes) {
        super(name, releaseYear, genre, language, about);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }
}

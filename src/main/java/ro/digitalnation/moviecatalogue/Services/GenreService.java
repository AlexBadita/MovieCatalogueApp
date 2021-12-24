package ro.digitalnation.moviecatalogue.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.moviecatalogue.Models.Genre;
import ro.digitalnation.moviecatalogue.Repositories.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public Genre getGenre(Integer id){
        return genreRepository.findById(id).get();
    }

    public void saveGenre(Genre genre){
        genreRepository.save(genre);
    }

    public void deleteGenre(Integer id){
        genreRepository.deleteById(id);
    }
}

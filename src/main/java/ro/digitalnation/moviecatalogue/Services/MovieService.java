package ro.digitalnation.moviecatalogue.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.moviecatalogue.Models.Movie;
import ro.digitalnation.moviecatalogue.Repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer id){
        return movieRepository.findById(id).get();
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }
}

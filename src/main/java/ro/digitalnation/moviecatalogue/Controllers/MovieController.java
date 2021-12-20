package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.digitalnation.moviecatalogue.Models.Movie;
import ro.digitalnation.moviecatalogue.Services.MovieService;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public String getAllMovies(Model model){
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping("/movies/{id}")
    public Movie getMovie(@PathVariable Integer id){
        return movieService.getMovie(id);
    }

    @RequestMapping("/addmovie")
    public String addMovie(Model model){
        model.addAttribute("movie", new Movie());
        return "addmovie";
    }

    @PostMapping("/savemovie")
    public String createMovie(@ModelAttribute("movie") Movie movie){
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

    @PutMapping("/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
        movieService.updateMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }
}

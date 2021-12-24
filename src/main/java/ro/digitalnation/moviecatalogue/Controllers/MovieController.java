package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.digitalnation.moviecatalogue.Models.Genre;
import ro.digitalnation.moviecatalogue.Models.Language;
import ro.digitalnation.moviecatalogue.Models.Movie;
import ro.digitalnation.moviecatalogue.Services.GenreService;
import ro.digitalnation.moviecatalogue.Services.LanguageService;
import ro.digitalnation.moviecatalogue.Services.MovieService;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private GenreService genreService;

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
        List<Genre> genres = genreService.getAllGenres();
        List<Language> languages = languageService.getAllLanguages();

        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", genres);
        model.addAttribute("languages", languages);

        return "add_movie";
    }

    @PostMapping("/savemovie")
    public String createMovie(@ModelAttribute("movie") Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @RequestMapping("/updatemovie/{id}")
    public String updateMovie(@PathVariable(value = "id") Integer id, Model model){
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);

        List<Genre> genres = genreService.getAllGenres();
        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("genres", genres);
        model.addAttribute("languages", languages);

        return "update_movie";
    }

    @RequestMapping("/deletemovie/{id}")
    public String deleteMovie(@PathVariable(value = "id") Integer id){
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}

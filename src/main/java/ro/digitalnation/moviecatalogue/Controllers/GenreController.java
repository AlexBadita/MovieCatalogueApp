package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.digitalnation.moviecatalogue.Models.Genre;
import ro.digitalnation.moviecatalogue.Models.Movie;
import ro.digitalnation.moviecatalogue.Services.GenreService;
import ro.digitalnation.moviecatalogue.Services.MovieService;

import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping("/genres")
    public String getAllGenres(Model model){
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @RequestMapping("/genres/{id}")
    public Genre getGenre(@PathVariable Integer id){
        return genreService.getGenre(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/genres/addgenre")
    public void addGenre(@RequestBody Genre genre){
        genreService.addGenre(genre);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/genres/update/{id}")
    public void updateGenre(@RequestBody Genre genre, @PathVariable Integer id){
        genreService.updateGenre(genre);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/genres/delete/{id}")
    public void deleteGenre(@PathVariable Integer id){
        genreService.deleteGenre(id);
    }
}

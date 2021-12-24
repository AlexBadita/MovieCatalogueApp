package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.digitalnation.moviecatalogue.Models.Genre;
import ro.digitalnation.moviecatalogue.Services.GenreService;

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

    @RequestMapping("/addgenre")
    public String addGenre(Model model){
        model.addAttribute("genre", new Genre());
        return "add_genre";
    }

    @PostMapping("/savegenre")
    public String createGenre(@ModelAttribute("genre") Genre genre){
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @RequestMapping("/updategenre/{id}")
    public String updateGenre(@PathVariable(value = "id") Integer id, Model model){
        Genre genre = genreService.getGenre(id);
        model.addAttribute("genre", genre);
        return "update_genre";
    }

    @RequestMapping("/deletegenre/{id}")
    public String deleteGenre(@PathVariable(value = "id") Integer id){
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}

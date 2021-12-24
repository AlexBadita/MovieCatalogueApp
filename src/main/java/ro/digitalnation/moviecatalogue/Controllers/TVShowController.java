package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.digitalnation.moviecatalogue.Models.Genre;
import ro.digitalnation.moviecatalogue.Models.Language;
import ro.digitalnation.moviecatalogue.Models.TVShow;
import ro.digitalnation.moviecatalogue.Services.GenreService;
import ro.digitalnation.moviecatalogue.Services.LanguageService;
import ro.digitalnation.moviecatalogue.Services.TVShowService;

import java.util.List;

@Controller
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private GenreService genreService;

    @RequestMapping("/tvshows")
    public String getAllTVShows(Model model){
        List<TVShow> tvShows = tvShowService.getAllTVShows();
        model.addAttribute("tvshows", tvShows);
        return "tvshows";
    }

    @RequestMapping("/tvshows/{id}")
    public TVShow getTVShow(@PathVariable Integer id){
        return tvShowService.getTVShow(id);
    }

    @RequestMapping("/addtvshow")
    public String addTVShow(Model model){
        List<Genre> genres = genreService.getAllGenres();
        List<Language> languages = languageService.getAllLanguages();

        model.addAttribute("tvshow", new TVShow());
        model.addAttribute("genres", genres);
        model.addAttribute("languages", languages);

        return "add_tvshow";
    }

    @PostMapping("/savetvshow")
    public String createTVShow(@ModelAttribute("tvshow") TVShow tvShow){
        tvShowService.saveTVShow(tvShow);
        return "redirect:/tvshows";
    }

    @RequestMapping("/updatetvshow/{id}")
    public String updateTVShow(@PathVariable(value = "id") Integer id, Model model){
        TVShow tvShow = tvShowService.getTVShow(id);
        model.addAttribute("tvshow", tvShow);

        List<Genre> genres = genreService.getAllGenres();
        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("genres", genres);
        model.addAttribute("languages", languages);

        return "update_tvshow";
    }

    @RequestMapping("/deletetvshow/{id}")
    public String deleteTVShow(@PathVariable(value = "id") Integer id){
        tvShowService.deleteTVShow(id);
        return "redirect:/tvshows";
    }
}

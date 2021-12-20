package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.digitalnation.moviecatalogue.Models.Movie;
import ro.digitalnation.moviecatalogue.Models.TVShow;
import ro.digitalnation.moviecatalogue.Services.TVShowService;

import java.util.List;

@Controller
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

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
    public String addTVShow(@RequestBody TVShow tvShow){
        tvShowService.addTVShow(tvShow);
        return "addtvshow";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tvshows/{id}")
    public void updateTVShow(@RequestBody TVShow tvShow, @PathVariable Integer id){
        tvShowService.updateTVShow(tvShow);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tvshows/{id}")
    public void deleteTVShow(@PathVariable Integer id){
        tvShowService.deleteTVShow(id);
    }
}

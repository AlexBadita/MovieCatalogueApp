package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.digitalnation.moviecatalogue.Models.Language;
import ro.digitalnation.moviecatalogue.Models.Movie;
import ro.digitalnation.moviecatalogue.Services.LanguageService;
import ro.digitalnation.moviecatalogue.Services.MovieService;

import java.util.List;

@Controller
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping("/languages")
    public String getAllLanguages(Model model){
        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("languages", languages);
        return "languages";
    }

    @RequestMapping("/languages/{id}")
    public Language getLanguage(@PathVariable Integer id){
        return languageService.getLanguage(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/languages/addlanguages")
    public void addLanguage(@RequestBody Language language){
        languageService.addLanguage(language);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/languages/update/{id}")
    public void updateLanguage(@RequestBody Language language, @PathVariable Integer id){
        languageService.updateLanguage(language);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/languages/delete/{id}")
    public void deleteLanguage(@PathVariable Integer id){

        languageService.deleteLanguage(id);
    }
}

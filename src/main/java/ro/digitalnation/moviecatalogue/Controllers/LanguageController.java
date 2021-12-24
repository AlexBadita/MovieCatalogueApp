package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.digitalnation.moviecatalogue.Models.Language;
import ro.digitalnation.moviecatalogue.Services.LanguageService;

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

    @RequestMapping("/addlanguage")
    public String addLanguage(Model model){
        model.addAttribute("language", new Language());
        return "add_language";
    }

    @RequestMapping("/savelanguage")
    public String saveLanguage(@ModelAttribute("language") Language language){
        languageService.saveLanguage(language);
        return "redirect:/languages";
    }

    @RequestMapping("/updatelanguage/{id}")
    public String updateLanguage(@PathVariable(value = "id") Integer id, Model model){
        Language language = languageService.getLanguage(id);
        model.addAttribute("language", language);
        return "update_language";
    }

    @RequestMapping("/deletelanguage/{id}")
    public String deleteLanguage(@PathVariable(value = "id") Integer id){
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}

package ro.digitalnation.moviecatalogue.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.moviecatalogue.Models.Language;
import ro.digitalnation.moviecatalogue.Repositories.LanguageRepository;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAllLanguages(){
        return languageRepository.findAll();
    }

    public Language getLanguage(Integer id){
        return languageRepository.findById(id).get();
    }

    public void addLanguage(Language language){
        languageRepository.save(language);
    }

    public void updateLanguage(Language language){
        languageRepository.save(language);
    }

    public void deleteLanguage(Integer id){
        languageRepository.deleteById(id);
    }
}

package ro.digitalnation.moviecatalogue.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.moviecatalogue.Models.TVShow;
import ro.digitalnation.moviecatalogue.Repositories.TVShowRepository;

import java.util.List;

@Service
public class TVShowService {

    @Autowired
    private TVShowRepository tvShowRepository;

    public List<TVShow> getAllTVShows(){
        return tvShowRepository.findAll();
    }

    public TVShow getTVShow(Integer id){
        return tvShowRepository.findById(id).get();
    }

    public void addTVShow(TVShow tvShow){
        tvShowRepository.save(tvShow);
    }

    public void updateTVShow(TVShow tvShow){
        tvShowRepository.save(tvShow);
    }

    public void deleteTVShow(Integer id){
        tvShowRepository.deleteById(id);
    }
}

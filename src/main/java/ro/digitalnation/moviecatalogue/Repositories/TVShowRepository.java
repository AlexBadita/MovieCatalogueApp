package ro.digitalnation.moviecatalogue.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.moviecatalogue.Models.TVShow;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow, Integer> {
}

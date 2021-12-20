package ro.digitalnation.moviecatalogue.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.moviecatalogue.Models.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}

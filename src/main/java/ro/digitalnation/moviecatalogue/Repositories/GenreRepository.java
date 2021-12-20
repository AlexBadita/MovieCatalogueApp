package ro.digitalnation.moviecatalogue.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.moviecatalogue.Models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}

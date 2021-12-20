package ro.digitalnation.moviecatalogue.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.moviecatalogue.Models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

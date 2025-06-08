package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.DisplayAccommodationsByHost;
import mk.ukim.finki.lab1b.model.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
    @Query("SELECT a.category, COUNT(a) FROM Accommodation a GROUP BY a.category")
    List<Object[]> countByCategory();

    @Query(value = "SELECT * FROM display_accommodations_by_host", nativeQuery = true)
    List<DisplayAccommodationsByHost> findAllFromMaterializedView();
}

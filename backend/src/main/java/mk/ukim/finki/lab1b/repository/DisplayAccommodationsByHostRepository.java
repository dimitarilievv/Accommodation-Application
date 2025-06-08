package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.DisplayAccommodationsByHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisplayAccommodationsByHostRepository extends JpaRepository<DisplayAccommodationsByHost, String> {
    List<DisplayAccommodationsByHost> findAll();
}
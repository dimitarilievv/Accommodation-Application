package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

}

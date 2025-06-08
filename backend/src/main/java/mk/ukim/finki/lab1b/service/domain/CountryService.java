package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(Country country);
    Optional<Country> update(Long id,Country country);
    void deleteById(Long id);
}

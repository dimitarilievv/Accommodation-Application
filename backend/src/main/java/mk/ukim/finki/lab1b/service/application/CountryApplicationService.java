package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateCountryDto;
import mk.ukim.finki.lab1b.dto.DisplayCountryDto;
import mk.ukim.finki.lab1b.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
    Optional<DisplayCountryDto> save(CreateCountryDto country);
    Optional<DisplayCountryDto> update(Long id,CreateCountryDto country);
    void deleteById(Long id);
}

package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.domain.Country;
import mk.ukim.finki.lab1b.model.domain.Host;

public record CreateCountryDto(String name, String continent) {
    public Country toCountry(){
        return new Country(name,continent);
    }
}

package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.domain.Accommodation;
import mk.ukim.finki.lab1b.model.domain.Host;
import mk.ukim.finki.lab1b.model.enumerations.Category;

public record CreateAccommodationDto(String name, Category category, Long hostId, Integer numRooms) {
    public Accommodation toAccommodation(Host host){
        return new Accommodation(name,category,host,numRooms);
    }
}

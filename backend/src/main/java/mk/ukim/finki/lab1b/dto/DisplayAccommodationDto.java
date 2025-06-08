package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.domain.Accommodation;
import mk.ukim.finki.lab1b.model.domain.Host;
import mk.ukim.finki.lab1b.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(Long id,
                                      String name,
                                      Category category,
                                      Host host,
                                      Integer numRooms){
    public static DisplayAccommodationDto from(Accommodation accommodation){
        return new DisplayAccommodationDto(accommodation.getId(),
                accommodation.getName(),accommodation.getCategory(),
                accommodation.getHost(),accommodation.getNumRooms());
    }
    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations){
        return accommodations.stream()
                .map(DisplayAccommodationDto::from)
                .collect(Collectors.toList());
    }
}

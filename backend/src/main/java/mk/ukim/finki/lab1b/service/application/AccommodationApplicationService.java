package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    List<DisplayAccommodationDto> findAll();
    Optional<DisplayAccommodationDto> findById(Long id);
    Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodation);
    Optional<DisplayAccommodationDto> update(Long id,CreateAccommodationDto accommodationDto);
    void deleteById(Long id);
    Optional<DisplayAccommodationDto> rentRoom(Long id);
}

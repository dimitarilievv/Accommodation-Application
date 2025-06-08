package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.model.domain.Accommodation;
import mk.ukim.finki.lab1b.model.domain.User;
import mk.ukim.finki.lab1b.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
    List<Accommodation> addAccommodationToTempList(String username, Long accommodationId);
    List<Accommodation> getUserTempList(String username);
    List<Accommodation> rentAllAccommodationsFromTempList(String username);
}
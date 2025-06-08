package mk.ukim.finki.lab1b.service.domain.impl;

import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.model.domain.Accommodation;
import mk.ukim.finki.lab1b.model.domain.User;
import mk.ukim.finki.lab1b.model.enumerations.Role;
import mk.ukim.finki.lab1b.model.exceptions.*;
import mk.ukim.finki.lab1b.repository.UserRepository;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AccommodationService accommodationService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AccommodationService accommodationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accommodationService = accommodationService;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword)) throw new PasswordsDoNotMatchException();
        if (userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, passwordEncoder.encode(password), name, surname, role);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(username + " not found"));
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new RuntimeException("Passwords do not match");
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public List<Accommodation> addAccommodationToTempList(String username, Long accommodationId) {
        Accommodation accommodation = accommodationService.findById(accommodationId).get();
        User user = userRepository.findByUsername(username).get();
        if(accommodation.getNumRooms()>0)
        {
            user.getTemporaryReservations().add(accommodation);
            userRepository.save(user);
            return user.getTemporaryReservations();
        }
        throw new RuntimeException("No available rooms for this accommodation");
    }

    @Override
    public List<Accommodation> getUserTempList(String username) {
        User user = userRepository.findByUsername(username).get();
        return user.getTemporaryReservations();
    }

    @Override
    public List<Accommodation> rentAllAccommodationsFromTempList(String username) {
        User user = userRepository.findByUsername(username).get();
        List<Accommodation> tempList=user.getTemporaryReservations();
        tempList.stream().forEach(a-> {
            accommodationService.rentRoom(a.getId());
            }
        );
        return tempList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
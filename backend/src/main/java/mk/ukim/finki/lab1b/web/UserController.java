package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab1b.dto.*;
import mk.ukim.finki.lab1b.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.lab1b.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.lab1b.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.lab1b.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User API", description = "Endpoints for user authentication and registration") // Swagger tag
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and starts a session")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        try {
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(RuntimeException::new);
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @Operation(summary = "User logout", description = "Ends the user's session")
//    @ApiResponse(responseCode = "200", description = "User logged out successfully")
//    @GetMapping("/logout")
//    public void logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }

    @Operation(summary = "My temporary reservations", description = "Shows the list of reservations in temporary reservation list")
    @GetMapping("/temporary_list/{username}")
    public List<DisplayAccommodationDto> getUserTempList(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userApplicationService.getUserTempList(username);
    }

    @Operation(summary = "Add reservation to temporary list", description = "Adds a reservation in temporary reservation list")
    @PostMapping("/add_to_templist/{username}")
    public List<DisplayAccommodationDto> addReservationToTempList(@RequestBody Long accommodationId){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userApplicationService.addAccommodationToTempList(username,accommodationId);
    }

    @Operation(summary = "My temporary list", description = "Shows the list of accommodations in temp list")
    @GetMapping("/rent_templist/{username}")
    public List<DisplayAccommodationDto> rentAllWishList(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userApplicationService.rentAllAccommodationsFromTempList(username);
    }
}
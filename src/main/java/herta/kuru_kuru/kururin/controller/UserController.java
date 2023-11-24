package herta.kuru_kuru.kururin.controller;

import herta.kuru_kuru.kururin.dto.RegistrationCredentialsDTO;
import herta.kuru_kuru.kururin.model.User;
import herta.kuru_kuru.kururin.exceptions.BadRequestException;
import herta.kuru_kuru.kururin.exceptions.EmailExistsException;
import herta.kuru_kuru.kururin.exceptions.UsernameExistsException;
import herta.kuru_kuru.kururin.repository.UserRepository;
import herta.kuru_kuru.kururin.security.PasswordEncoder;
import herta.kuru_kuru.kururin.security.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationCredentialsDTO registrationCredentials) {
        // Validate the registration credentials
        if (!isValidRegistrationCredentials(registrationCredentials)) {
            throw new BadRequestException("Invalid registration credentials");
        }

        // Check if username already exists
        if (userRepository.existsByUsername(registrationCredentials.getUsername())) {
            throw new UsernameExistsException("Username already exists");
        }

        // Check if email already exists
        if (userRepository.existsByEmail(registrationCredentials.getEmail())) {
            throw new EmailExistsException("Email already exists");
        }

        // Encrypt the password
        String hashedPassword = passwordEncoder.encode(registrationCredentials.getPassword());

        // Create a new user
        User user = new User();
        user.setUsername(registrationCredentials.getUsername());
        user.setEmail(registrationCredentials.getEmail());
        user.setPassword(hashedPassword);
        user.setRole(RoleName.USER);
        user.setEnabled(true);

        // Save the user to the database
        user = userRepository.save(user);

        // Remove the password from the user object before returning
        user.setPassword(null);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    private boolean isValidRegistrationCredentials(RegistrationCredentialsDTO registrationCredentials) {
        // Validate all registration credentials here
        return registrationCredentials != null &&
                registrationCredentials.getUsername() != null && !registrationCredentials.getUsername().isEmpty() &&
                registrationCredentials.getEmail() != null && !registrationCredentials.getEmail().isEmpty() &&
                registrationCredentials.getPassword() != null && !registrationCredentials.getPassword().isEmpty();
    }
}

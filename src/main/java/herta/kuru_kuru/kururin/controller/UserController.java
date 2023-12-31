package herta.kuru_kuru.kururin.controller;

import herta.kuru_kuru.kururin.dto.RegistrationCredentialsDTO;
import herta.kuru_kuru.kururin.model.User;
import herta.kuru_kuru.kururin.exceptions.BadRequestException;
import herta.kuru_kuru.kururin.exceptions.EmailExistsException;
import herta.kuru_kuru.kururin.exceptions.UsernameExistsException;
import herta.kuru_kuru.kururin.repository.UserRepository;
import herta.kuru_kuru.kururin.infrastructure.security.PasswordEncoderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationCredentialsDTO registrationCredentials) {
        if (!isValidRegistrationCredentials(registrationCredentials)) {
            throw new BadRequestException("Invalid registration credentials");
        }

        if (userRepository.existsByUsername(registrationCredentials.getUsername())) {
            throw new UsernameExistsException("Username already exists");
        }

        if (userRepository.existsByEmail(registrationCredentials.getEmail())) {
            throw new EmailExistsException("Email already exists");
        }

        String hashedPassword = passwordEncoder.encode(registrationCredentials.getPassword());

        User user = new User();
        user.setUsername(registrationCredentials.getUsername());
        user.setEmail(registrationCredentials.getEmail());
        user.setPassword(hashedPassword);
        user.setEnabled(true);

        user = userRepository.save(user);

        user.setPassword(null);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    private boolean isValidRegistrationCredentials(RegistrationCredentialsDTO registrationCredentials) {
        return registrationCredentials != null &&
                registrationCredentials.getUsername() != null && !registrationCredentials.getUsername().isEmpty() &&
                registrationCredentials.getEmail() != null && !registrationCredentials.getEmail().isEmpty() &&
                registrationCredentials.getPassword() != null && !registrationCredentials.getPassword().isEmpty();
    }
}

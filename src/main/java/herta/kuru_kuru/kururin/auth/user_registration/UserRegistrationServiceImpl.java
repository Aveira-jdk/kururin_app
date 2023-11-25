package herta.kuru_kuru.kururin.auth.user_registration;

import herta.kuru_kuru.kururin.model.User;
import herta.kuru_kuru.kururin.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegistrationCredentialsDTO registrationCredentials) throws UserRegistrationException {
        if (!isValidRegistrationCredentials(registrationCredentials)) {
            throw new InvalidRegistrationCredentialsException("Invalid registration credentials");
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

        userRepository.save(user);
    }

    private boolean isValidRegistrationCredentials(RegistrationCredentialsDTO registrationCredentials) {
        return registrationCredentials != null &&
                registrationCredentials.getUsername() != null && !registrationCredentials.getUsername().isEmpty() &&
                registrationCredentials.getEmail() != null && !registrationCredentials.getEmail().isEmpty() &&
                registrationCredentials.getPassword() != null && !registrationCredentials.getPassword().isEmpty();
    }
}
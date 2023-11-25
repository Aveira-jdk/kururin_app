package herta.kuru_kuru.kururin.auth.user_sign_in;

import herta.kuru_kuru.kururin.dto.LoginCredentialsDTO;
import herta.kuru_kuru.kururin.model.User;
import herta.kuru_kuru.kururin.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserSignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSignInService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User loginUser(LoginCredentialsDTO loginCredentials) throws UserLoginException {
        if (!isValidLoginCredentials(loginCredentials)) {
            throw new InvalidLoginCredentialsException("Invalid login credentials");
        }

        User user = userRepository.findByEmail(loginCredentials.getEmail());
        if (user == null || !passwordEncoder.matches(loginCredentials.getPassword(), user.getPassword())) {
            throw new UserNotFoundException("User not found or password incorrect");
        }

        return user;
    }

    private boolean isValidLoginCredentials(LoginCredentialsDTO loginCredentials) {
        return loginCredentials != null &&
                loginCredentials.getEmail() != null && !loginCredentials.getEmail().isEmpty() &&
                loginCredentials.getPassword() != null && !loginCredentials.getPassword().isEmpty();
    }
}

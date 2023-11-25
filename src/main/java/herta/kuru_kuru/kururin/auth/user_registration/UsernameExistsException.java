package herta.kuru_kuru.kururin.auth.user_registration;

public class UsernameExistsException extends UserRegistrationException {

    public UsernameExistsException(String message) {
        super(message);
    }
}

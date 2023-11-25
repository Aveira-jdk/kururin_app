package herta.kuru_kuru.kururin.auth.user_registration;

public class EmailExistsException extends UserRegistrationException {
    public EmailExistsException(String message) {
        super(message);
    }
}

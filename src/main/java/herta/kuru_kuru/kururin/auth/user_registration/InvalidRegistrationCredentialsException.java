package herta.kuru_kuru.kururin.auth.user_registration;

public class InvalidRegistrationCredentialsException extends RuntimeException {

    public InvalidRegistrationCredentialsException(String message) {
        super(message);
    }
}

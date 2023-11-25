package herta.kuru_kuru.kururin.auth.user_sign_in;

public class InvalidLoginCredentialsException extends UserLoginException {

    public InvalidLoginCredentialsException(String message) {
        super(message);
    }
}


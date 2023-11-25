package herta.kuru_kuru.kururin.auth.user_sign_in;

public class UserNotFoundException extends UserLoginException {

    public UserNotFoundException(String message) {
        super(message);
    }
}

package herta.kuru_kuru.kururin.auth.user_registration;


public interface UserRegistrationService {
    void registerUser(RegistrationCredentialsDTO registrationCredentials) throws UserRegistrationException;

}
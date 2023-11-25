package herta.kuru_kuru.kururin.auth.user_registration;

import lombok.Data;

@Data
public class RegistrationCredentialsDTO {

    private String username;
    private String email;
    private String password;
}

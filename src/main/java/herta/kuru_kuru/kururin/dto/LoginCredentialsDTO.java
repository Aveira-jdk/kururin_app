package herta.kuru_kuru.kururin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredentialsDTO {
    @NotBlank(message = "Username or email is required")
    @Pattern(regexp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,}$",
            message = "Invalid email format")
    @Email(message = "Invalid email format")
    private String usernameOrEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$^%&+=])(?=\\S+$).{8,}$",
            message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character, and no whitespaces")
    private String password;

    private String totpCode;

    private String userAgent;

    private Long loginAttemptAt;

    private String Email;
}

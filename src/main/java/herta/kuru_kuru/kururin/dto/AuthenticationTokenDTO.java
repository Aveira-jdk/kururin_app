package herta.kuru_kuru.kururin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationTokenDTO {

    private String token;
    private Long userId;
    private String username;
    private String role;
    private LocalDateTime issuedAt;
    private LocalDateTime expiresAt;
}

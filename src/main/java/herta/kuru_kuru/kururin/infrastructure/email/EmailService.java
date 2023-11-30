package herta.kuru_kuru.kururin.infrastructure.email;

public interface EmailService {

    void sendOtp(String to, String subject, String otp);
}

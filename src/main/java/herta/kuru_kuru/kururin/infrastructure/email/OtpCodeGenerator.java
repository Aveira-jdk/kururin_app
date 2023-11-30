package herta.kuru_kuru.kururin.infrastructure.email;

import java.security.SecureRandom;

public class OtpCodeGenerator {

    private static final String OTP_CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6;

    public static String generateOtp() {
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(OTP_CHARACTERS.length());
            otp.append(OTP_CHARACTERS.charAt(randomIndex));
        }

        return otp.toString();
    }
}

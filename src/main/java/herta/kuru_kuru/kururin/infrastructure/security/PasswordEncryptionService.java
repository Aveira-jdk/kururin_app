package herta.kuru_kuru.kururin.infrastructure.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptionService {

    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}

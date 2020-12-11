package university.innopolis.stc.refactoring.crypto;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordEncoder {

    public static String encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean matches(String rawPasword, String encodedPassword) {
        return encode(rawPasword).equals(encodedPassword);
    }
}

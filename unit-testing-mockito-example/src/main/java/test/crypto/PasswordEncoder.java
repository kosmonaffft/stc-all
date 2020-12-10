package test.crypto;

public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String rawPasword, String encodedPassword);
}

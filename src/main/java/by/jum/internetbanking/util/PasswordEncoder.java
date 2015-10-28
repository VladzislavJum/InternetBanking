package by.jum.internetbanking.util;

/**
 * Created by Vlad on 28.10.2015.
 */
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    public static final int SALT_LENGTH = 16;
    public static final int SALT_PLACE = 73;

    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}

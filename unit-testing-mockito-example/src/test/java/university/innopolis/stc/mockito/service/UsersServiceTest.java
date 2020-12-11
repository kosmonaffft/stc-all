package university.innopolis.stc.mockito.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.innopolis.stc.mockito.crypto.PasswordEncoder;
import university.innopolis.stc.mockito.db.Repository;
import university.innopolis.stc.mockito.entity.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsersServiceTest {

    public static final String LOGIN = "kosmonaFFFt";

    public static final String PASSWORD = "qwerty1234567890!!!";

    private static UsersService service;

    private static PasswordEncoder passwordEncoder;

    private static User kosmonaFFFt;

    private static String encodedPassword;

    @BeforeAll
    static void setUp() {

        encodedPassword = Base64.getEncoder().encodeToString(PASSWORD.getBytes(StandardCharsets.UTF_8));

        kosmonaFFFt = new User() {{
            setId(1L);
            setLogin(LOGIN);
            setEncodedPassword(PASSWORD);
        }};

        kosmonaFFFt = Mockito.spy(kosmonaFFFt);

        passwordEncoder = mock(PasswordEncoder.class);
        Repository repository = mock(Repository.class);

        when(repository.findByLogin(LOGIN))
                .thenReturn(Optional.of(kosmonaFFFt));
        when(repository.getById(anyLong()))
                .thenReturn(kosmonaFFFt);

        when(passwordEncoder.matches(anyString(), eq(PASSWORD)))
                .thenReturn(false);
        when(passwordEncoder.matches(PASSWORD, PASSWORD))
                .thenReturn(true);
        when(passwordEncoder.matches(PASSWORD, encodedPassword))
                .thenReturn(true);
        when(passwordEncoder.encode(anyString()))
                .thenReturn(encodedPassword);

        service = new UsersService(passwordEncoder, repository);
    }

    @AfterAll
    static void tearDown() {
    }

    @Test
    void changePassword() {
        service.changePassword(1L, PASSWORD, "123", "123");
        verify(passwordEncoder, times(1))
                .encode(anyString());
        verify(kosmonaFFFt, times(1))
                .setEncodedPassword(encodedPassword);

        assertThrows(RuntimeException.class, () -> {
            service.changePassword(1L, PASSWORD, "123", "1234");
        });

        assertThrows(RuntimeException.class, () -> {
            service.changePassword(1L, "123", "123", "123");
        });
    }

    @Test
    void authorize() {
        boolean authorized = service.authorize(LOGIN, PASSWORD);
        assertTrue(authorized);
    }
}
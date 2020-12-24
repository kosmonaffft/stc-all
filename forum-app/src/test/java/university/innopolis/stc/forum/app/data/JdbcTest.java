package university.innopolis.stc.forum.app.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import university.innopolis.stc.forum.app.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class JdbcTest extends BaseTest {

    private static Jdbc jdbc;

    @BeforeAll
    public static void init() throws IOException {
        BaseTest.init();
        jdbc = JdbcFactory.instance.getJdbc();
    }

    @Test
    void getUserByEmail() {
        final Map<String, Object> userByEmail = jdbc.getUserByEmail("user1@mail.ru");
        Assertions.assertNotNull(userByEmail);
    }

    @Test
    void insertUser() {
        final Map<String, Object> user = jdbc.insertUser(new HashMap<String, Object>() {{
            put("email", "test@test.org");
            put("password_hash", "hash");
            put("full_name", "Test Test Test");
        }});
    }
}
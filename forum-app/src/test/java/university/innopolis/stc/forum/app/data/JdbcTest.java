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
        jdbc = new JdbcFactory().getJdbc();
    }

    @Test
    void getUserByEmail() {
        Map<String, Object> userByEmail = jdbc.getUserByLogin("login01");
        Assertions.assertNotNull(userByEmail);
    }

    @Test
    void insertUser() {
        Map<String, Object> user = jdbc.insertUser(new HashMap<String, Object>() {{
            put("login", "test_login");
            put("password", "asdfghjkl");
        }});
    }
}
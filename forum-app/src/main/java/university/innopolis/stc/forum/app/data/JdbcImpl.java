package university.innopolis.stc.forum.app.data;

import java.util.Map;

public class JdbcImpl implements Jdbc {

    @Override
    public Map<String, Object> getUserByEmail(String email) {
        throw new RuntimeException();
    }

    @Override
    public Map<String, Object> insertUser(Map<String, Object> user) {
        throw new RuntimeException();

    }
}

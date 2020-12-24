package university.innopolis.stc.forum.app.data;

import java.util.Map;

public interface Jdbc {

    Map<String, Object> getUserByLogin(String login);

    Map<String, Object> insertUser(Map<String, Object> user);
}

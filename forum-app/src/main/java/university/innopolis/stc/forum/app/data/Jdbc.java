package university.innopolis.stc.forum.app.data;

import java.util.Map;

public interface Jdbc {

    Map<String, Object> getUserByEmail(String email);

    Map<String, Object> insertUser(Map<String, Object> user);
}

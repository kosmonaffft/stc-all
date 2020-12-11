package university.innopolis.stc.refactoring.repository;

import university.innopolis.stc.refactoring.db.DbConnection;
import university.innopolis.stc.refactoring.entity.User;

public class UsersRepository {

    public static User find(Long id, String login) {
        return DbConnection.getInstance().getUser(id);
    }

    public void save(User user) {
        DbConnection.getInstance().saveUser(user);
    }
}

package university.innopolis.stc.refactoring.repository;

import university.innopolis.stc.refactoring.db.IDBConnection;
import university.innopolis.stc.refactoring.entity.User;

public class UsersRepository {

    private final IDBConnection connection;

    public UsersRepository(IDBConnection connection) {
        this.connection = connection;
    }

    public User find(Long id, String login) {
        return connection.getUser(id);
    }

    public void save(User user) {
        connection.saveUser(user);
    }
}

package university.innopolis.stc.refactoring.db;

import university.innopolis.stc.refactoring.entity.User;

public class DbConnection {

    private static DbConnection instance = new DbConnection();

    public static DbConnection getInstance() {
        return instance;
    }

    private DbConnection() {

    }

    public void saveUser(User user) {

    }

    public User getUser(Long id) {
        return null;
    }
}

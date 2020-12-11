package university.innopolis.stc.refactoring.db;

import university.innopolis.stc.refactoring.entity.User;

public class DbConnection implements IDBConnection {

    private DbConnection() {
        throw new RuntimeException("No connection to DB in unit tests!!!");
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(Long id) {
        return null;
    }
}

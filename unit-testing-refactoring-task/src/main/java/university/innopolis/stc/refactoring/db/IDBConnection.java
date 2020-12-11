package university.innopolis.stc.refactoring.db;

import university.innopolis.stc.refactoring.entity.User;

public interface IDBConnection {

    void saveUser(User user);

    User getUser(Long id);
}

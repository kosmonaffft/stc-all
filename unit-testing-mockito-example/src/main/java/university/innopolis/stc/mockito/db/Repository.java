package university.innopolis.stc.mockito.db;

import university.innopolis.stc.mockito.entity.User;

import java.util.Optional;

public interface Repository {

    User getById(Long id);

    Optional<User> findByLogin(String login);

    void update(Long id, User user);

    void insert(User user);
}

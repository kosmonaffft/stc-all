package test.db;

import test.entity.User;

import java.util.Optional;

public interface Repository {

    User getById(Long id);

    Optional<User> findByLogin(String login);

    void update(Long id, User user);

    void insert(User user);
}

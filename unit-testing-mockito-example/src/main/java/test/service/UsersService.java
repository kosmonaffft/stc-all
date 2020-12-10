package test.service;

import test.crypto.PasswordEncoder;
import test.db.Repository;
import test.entity.User;

import java.util.Objects;

public class UsersService {

    private PasswordEncoder passwordEncoder;

    private Repository repository;

    public UsersService(PasswordEncoder passwordEncoder, Repository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public void changePassword(Long userId,
                               String oldPassword,
                               String newPassword,
                               String passwordConfirmation) {
        if (!Objects.equals(newPassword, passwordConfirmation)) {
            throw new RuntimeException("Password mismatch!");
        }

        User user = repository.getById(userId);
        if (!passwordEncoder.matches(oldPassword, user.getEncodedPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        String s = passwordEncoder.encode(newPassword);
        user.setEncodedPassword(s);
        repository.update(userId, user);
    }

    public boolean authorize(String login,
                             String password) {
        return repository.findByLogin(login)
                .map(u -> passwordEncoder.matches(password, u.getEncodedPassword()))
                .orElse(false);
    }
}

package university.innopolis.stc.refactoring.service;

import university.innopolis.stc.refactoring.crypto.PasswordEncoder;
import university.innopolis.stc.refactoring.entity.User;
import university.innopolis.stc.refactoring.repository.UsersRepository;

import java.util.Objects;

public class UsersService {

    public void changePassword(Long userId,
                               String oldPassword,
                               String newPassword,
                               String passwordConfirmation) {
        if (!Objects.equals(newPassword, passwordConfirmation)) {
            throw new RuntimeException("Password mismatch!");
        }

        User user = UsersRepository.find(userId, null);
        if (!PasswordEncoder.matches(oldPassword, user.getEncodedPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        String s = PasswordEncoder.encode(newPassword);
        user.setEncodedPassword(s);
        new UsersRepository().save(user);
    }

    public boolean authorize(String login,
                             String password) {
        User u = UsersRepository.find(null, login);
        return PasswordEncoder.matches(password, u.getEncodedPassword());
    }
}

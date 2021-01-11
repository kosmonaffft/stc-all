package university.innopolis.stc.javaee;

import lombok.Cleanup;
import lombok.val;
import org.apache.commons.lang.RandomStringUtils;
import university.innopolis.stc.javaee.entity.Role;
import university.innopolis.stc.javaee.entity.Status;
import university.innopolis.stc.javaee.entity.User;

import javax.persistence.Persistence;
import java.time.LocalDate;

public class MainSimple {

    public static void main(String[] args) {
        val entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        @Cleanup val entityManager = entityManagerFactory.createEntityManager();

        val user = entityManager.find(User.class, 1L);
        System.out.printf("User with id=1: %s%n", user);

        entityManager.getTransaction().begin();

        User newUser = null;
        newUser.setLogin(RandomStringUtils.randomAlphabetic(16));
        newUser.setPassword(RandomStringUtils.randomAlphabetic(16));
        newUser.setRegistrationDate(LocalDate.now());
        newUser.setRole(entityManager.find(Role.class, 1L));
        newUser.setStatus(entityManager.find(Status.class, 1L));

        entityManager.persist(newUser);
        System.out.printf("New user: %s%n", newUser);

        user.setLogin(RandomStringUtils.randomAlphanumeric(8));

        val deletedUser = entityManager.find(User.class, newUser.getId() - 1);
        if (deletedUser != null) {
            entityManager.remove(deletedUser);
        }

        entityManager.getTransaction().commit();

        val allUsersQuery = entityManager.createNamedQuery("select_all_users", User.class);
        val users = allUsersQuery.getResultList();
        System.out.printf("All users: %s%n", users);

        val byLoginQuery = entityManager.createNamedQuery("select_by_login", User.class);
        byLoginQuery.setParameter("login", "login5");
        val usersByLogin = byLoginQuery.getResultList();
        System.out.printf("By login users: %s%n", usersByLogin);
    }
}

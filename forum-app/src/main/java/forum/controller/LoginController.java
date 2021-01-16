package forum.controller;

import forum.dto.LoginAndPassword;
import forum.entity.User;
import forum.utils.OptionalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Objects;

@Controller
public class LoginController {

    private final EntityManager entityManager;

    public LoginController(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @GetMapping(value = "/login")
    public String index() {
        return "login";
    }

    @PostMapping(value = "/login.do")
    public String doLogin(LoginAndPassword loginAndPassword) {

        return OptionalUtils.ofThrowable(
                () -> entityManager.createNamedQuery("findUserByLogin", User.class)
                        .setParameter("login", loginAndPassword.getEmail())
                        .getSingleResult()
        ).map(user -> {
            if (!Objects.equals(loginAndPassword.getPassword(), user.getPassword())) {
                throw new RuntimeException();
            }

            return "redirect:index";
        }).orElse("redirect:registration");
    }
}

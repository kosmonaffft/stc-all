package university.innopolis.stc.springbestpractices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import university.innopolis.stc.springbestpractices.entity.User;
import university.innopolis.stc.springbestpractices.repository.UsersRepository;

@Controller
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users/{id}/view")
    public String view(@PathVariable("id") Long id, Model model) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        model.addAttribute("user", user);
        return "view_user";
    }
}

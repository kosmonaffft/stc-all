package university.innopolis.stc.springbestpractices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import university.innopolis.stc.springbestpractices.dto.UserCreateDto;
import university.innopolis.stc.springbestpractices.dto.UserListDto;
import university.innopolis.stc.springbestpractices.service.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UsersRestController {

    private final UsersService usersService;

    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<UserListDto> getAll(@RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size,
                                    @RequestParam("sort") Optional<String> sort,
                                    @RequestParam("login") Optional<String> login,
                                    @RequestParam("role") Optional<String> role) {

        return usersService.getAll(page, size, sort, login, role);
    }

    @PostMapping
    public UserListDto create(@RequestBody UserCreateDto userCreateDto) {
        return usersService.create(userCreateDto);
    }
}

package university.innopolis.stc.layouts_example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestExampleController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello, world!!!";
    }
}

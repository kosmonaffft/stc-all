package forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class IndexController {

    @GetMapping(value = "index")
    public ModelAndView index1() {
        return index();
    }

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        result.getModelMap().addAttribute("name", "Anton");
        result.getModelMap().addAttribute("list", new ArrayList<String>() {{
            add("first");
            add("second");
            add("third");
            add("fourth");
            add("fourth");
            add("fourth");
            add("fourth");
        }});
        return result;
    }
}

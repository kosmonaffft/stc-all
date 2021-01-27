package university.innopolis.stc.layouts_example.controllers;

import lombok.val;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import university.innopolis.stc.layouts_example.data.ServiceEndpoint;
import university.innopolis.stc.layouts_example.datatable.ColumnDescription;

import java.util.Arrays;
import java.util.UUID;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("datatable")
    public String datatable(
            @RequestParam("page") @DefaultValue("0") Integer page,
            Model model
    ) {
        val columns2 = Arrays.asList(
                new ColumnDescription("Уникальный идентификатор", "id"),
                new ColumnDescription("Наименование", "name"),
                new ColumnDescription("Адрес", "url"),
                new ColumnDescription("Метод", "method")
        );
        val data2 = Arrays.asList(
                new ServiceEndpoint(UUID.randomUUID(), "Получить список пользователей", "/users", "GET"),
                new ServiceEndpoint(UUID.randomUUID(), "Получить пользователя", "/users/{id}", "GET"),
                new ServiceEndpoint(UUID.randomUUID(), "Содать пользователя", "/users", "POST"),
                new ServiceEndpoint(UUID.randomUUID(), "Изменить пользователя", "/users/{id}", "PUT"),
                new ServiceEndpoint(UUID.randomUUID(), "Удалить пользователя", "/users/{id}", "DELETE")
        );

        model.addAttribute("page", page);
        model.addAttribute("columns2", columns2);
        model.addAttribute("data2", data2);

        return "datatable";
    }
}

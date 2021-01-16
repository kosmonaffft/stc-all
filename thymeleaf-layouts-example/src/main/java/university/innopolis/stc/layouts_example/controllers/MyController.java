package university.innopolis.stc.layouts_example.controllers;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import university.innopolis.stc.layouts_example.data.ServiceEndpoint;
import university.innopolis.stc.layouts_example.datatable.ColumnDescription;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("datatable")
    public String datatable(Model model) {
        val columns1 = Arrays.asList(
                new ColumnDescription("id", "id"),
                new ColumnDescription("Имя", "name"),
                new ColumnDescription("Дата рождения", "birthdayDate")
        );
        val data1 = Arrays.asList(
                new HashMap<String, String>() {{
                    put("id", "1");
                    put("name", "Антон1");
                    put("birthdayDate", "1989");
                }},
                new HashMap<String, String>() {{
                    put("id", "2");
                    put("name", "Антон2");
                    put("birthdayDate", "1990");
                }},
                new HashMap<String, String>() {{
                    put("id", "3");
                    put("name", "Антон3");
                    put("birthdayDate", "1991");
                }}
        );

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

        model.addAttribute("columns1", columns1);
        model.addAttribute("data1", data1);

        model.addAttribute("columns2", columns2);
        model.addAttribute("data2", data2);

        return "datatable";
    }
}

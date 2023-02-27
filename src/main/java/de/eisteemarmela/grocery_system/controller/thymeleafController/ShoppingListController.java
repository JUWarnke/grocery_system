package de.eisteemarmela.grocery_system.controller.thymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingListController {

    @GetMapping("todo")
    public String showTodoList() {
        return "todo";
    }

}

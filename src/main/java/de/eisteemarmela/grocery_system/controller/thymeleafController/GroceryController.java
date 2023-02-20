package de.eisteemarmela.grocery_system.controller.thymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroceryController {

    @GetMapping("/")
    public String showGroceryList( Model model ) {
        model.addAttribute( "helloworld", "Hello World!" );
        return "groceries";
    }

}

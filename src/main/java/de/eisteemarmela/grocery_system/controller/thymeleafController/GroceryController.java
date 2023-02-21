package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.services.GroceryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroceryController {

    GroceryService groceryService;

    public GroceryController( GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping( "/groceries" )
    public String showGroceryList( Model model ) {
        model.addAttribute( "groceries",  groceryService.getAllGroceries() );
        return "groceries";
    }

}

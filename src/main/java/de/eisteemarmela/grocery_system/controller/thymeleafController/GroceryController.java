package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.repositories.GroceryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroceryController {

    GroceryRepository groceryRepository;

    public GroceryController( GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @GetMapping( "/groceries" )
    public String showGroceryList( Model model ) {
        model.addAttribute( "groceries",  groceryRepository.findAll() );
        return "groceries";
    }

}

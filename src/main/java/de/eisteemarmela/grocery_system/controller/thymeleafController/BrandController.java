package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.repositories.BrandRepository;
import de.eisteemarmela.grocery_system.model.repositories.GroceryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {

    BrandRepository brandRepository;

    public BrandController( BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping( "/brands" )
    public String showGroceryList( Model model ) {
        model.addAttribute( "brands",  brandRepository.findAll() );
        return "brands";
    }

}

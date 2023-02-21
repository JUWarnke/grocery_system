package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.repositories.StoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    StoreRepository storeRepository;

    public StoreController( StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping( "/stores" )
    public String showStoreList( Model model ) {
        model.addAttribute( "stores",  storeRepository.findAll() );
        return "stores";
    }

}

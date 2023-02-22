package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Store;
import de.eisteemarmela.grocery_system.model.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {

    StoreService storeService;

    public StoreController( StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping( "/stores" )
    public String showStoreList( Model model ) {
        model.addAttribute( "stores",  storeService.getAllStores() );
        model.addAttribute( "addStore", new Store() );
        return "stores";
    }

    @PostMapping( "/stores/add" )
    public String saveBrand( @ModelAttribute("addStore") Store store ) {
        storeService.saveStore( store );
        return "redirect:/stores";
    }



}

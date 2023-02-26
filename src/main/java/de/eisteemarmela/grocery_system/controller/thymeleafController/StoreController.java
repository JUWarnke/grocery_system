package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Store;
import de.eisteemarmela.grocery_system.model.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("stores/delete/{id}")
    public String deleteStore(@PathVariable("id") Long id) {
        storeService.deleteStoreById(id);
        return "redirect:/stores";
    }

    @PostMapping( "/stores/add" )
    public String saveBrand( @ModelAttribute("addStore") Store store ) {
        storeService.saveStore( store );
        return "redirect:/stores";
    }

    @PostMapping("stores/edit")
    public String editStore(@RequestParam("storeId") Long id,
                            @RequestParam("storeName") String storeName) {

        Store store = storeService.getStoreById(id);
        store.setName( storeName );
        storeService.saveStore(store);
        return "redirect:/stores";
    }



}

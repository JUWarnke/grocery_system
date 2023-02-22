package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Grocery;
import de.eisteemarmela.grocery_system.model.entities.dataHolder.GroceryData;
import de.eisteemarmela.grocery_system.model.services.BrandService;
import de.eisteemarmela.grocery_system.model.services.GroceryService;
import de.eisteemarmela.grocery_system.model.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroceryController {

    GroceryService groceryService;

    BrandService brandService;

    StoreService storeService;

    public GroceryController( GroceryService groceryService, BrandService brandService, StoreService storeService ) {
        this.groceryService = groceryService;
        this.brandService = brandService;
        this.storeService = storeService;
    }

    @GetMapping( "/groceries" )
    public String showGroceryList( Model model ) {
        model.addAttribute( "groceries",  groceryService.getAllGroceries() );
        model.addAttribute( "stores", storeService.getAllStores() );
        model.addAttribute( "brands", brandService.getAllBrands() );
        model.addAttribute( "grocery", new Grocery() );
        return "groceries";
    }

    @PostMapping( "groceries/add" )
    public String saveGrocery( @ModelAttribute Grocery grocery ) {

        groceryService.saveGrocery( grocery );

        return "redirect:/groceries";
    }

    // delete grocery
    @GetMapping( "groceries/delete/{id}" )
    public String deleteGrocery( @PathVariable long id ) {

        groceryService.deleteGroceryById( id );

        return "redirect:/groceries";
    }

}

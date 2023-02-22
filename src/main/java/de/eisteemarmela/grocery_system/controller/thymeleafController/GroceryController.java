package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Grocery;
import de.eisteemarmela.grocery_system.model.entities.GroceryData;
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

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping( "/groceries" )
    public String showGroceryList( Model model ) {
        model.addAttribute( "groceries",  groceryService.getAllGroceries() );
        model.addAttribute( "stores", storeService.getAllStores() );
        model.addAttribute( "brands", brandService.getAllBrands() );
        model.addAttribute( "addGroceryData", new GroceryData() );
        return "groceries";
    }

    // save groceryData from form
    @PostMapping( "/add" )
    public String saveGrocery( @ModelAttribute("addGroceryData") GroceryData groceryData ) {

        Grocery grocery = new Grocery();
        grocery.setName( groceryData.getName() );
        grocery.setBrand( brandService.getBrandByName( groceryData.getBrand() ) );
        grocery.setStore( storeService.getStoreByName( groceryData.getStore() ) );
        grocery.setPrice( groceryData.getPrice() );
        grocery.setQuantity( groceryData.getQuantity() );
        grocery.setLastBought( groceryData.getLastBought() );

        groceryService.saveGrocery( grocery );

        return "redirect:/groceries";
    }

}

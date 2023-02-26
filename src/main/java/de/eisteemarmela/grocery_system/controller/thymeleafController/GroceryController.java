package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Grocery;
import de.eisteemarmela.grocery_system.model.services.BrandService;
import de.eisteemarmela.grocery_system.model.services.GroceryService;
import de.eisteemarmela.grocery_system.model.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
        model.addAttribute( "groceries", groceryService.getAllGroceries() );
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

    @PostMapping( "groceries/edit" )
    public String editGrocery( @RequestParam("groceryId") Long id,
                               @RequestParam("groceryName") String name,
                               @RequestParam("groceryBrandId") Long brandId,
                               @RequestParam("groceryPrice") Double price,
                               @RequestParam("groceryLastBought") LocalDate lastBought,
                               @RequestParam("groceryStoreId") Long storeId,
                               @RequestParam("groceryQuantity") String quantity ) {



        Grocery grocery = groceryService.getGroceryById( id );
        grocery.setName( name );
        grocery.setBrand( brandService.getBrandById( brandId ) );
        grocery.setPrice( price );
        grocery.setLastBought( lastBought );
        grocery.setStore( storeService.getStoreById( storeId ) );
        grocery.setQuantity( quantity );

        groceryService.saveGrocery( grocery );

        return "redirect:/groceries";
    }

    // delete grocery
    @GetMapping( "groceries/delete/{id}" )
    public String deleteGrocery( @PathVariable("id") Long groceryId ) {

        groceryService.deleteGroceryById( groceryId );

        return "redirect:/groceries";
    }
}

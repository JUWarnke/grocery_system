package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Brand;
import de.eisteemarmela.grocery_system.model.services.BrandService;
import de.eisteemarmela.grocery_system.model.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(  )
public class BrandController {

    BrandService brandService;
    StoreService storeService;

    public BrandController( BrandService brandService, StoreService storeService ) {
        this.brandService = brandService;
        this.storeService = storeService;
    }

    @GetMapping( "/brands" )
    public String showGroceryList( Model model ) {
        model.addAttribute( "brands",  brandService.getAllBrands() );
        model.addAttribute( "stores", storeService.getAllStores() );
        model.addAttribute( "addBrand", new Brand() );
        return "brands";
    }

    @PostMapping( "/brands/add" )
    public String saveBrand( @ModelAttribute("addBrand") Brand brand ) {
        brandService.saveBrand( brand );
        return "redirect:/brands";
    }

}

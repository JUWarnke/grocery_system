package de.eisteemarmela.grocery_system.controller.thymeleafController;

import de.eisteemarmela.grocery_system.model.entities.Brand;
import de.eisteemarmela.grocery_system.model.services.BrandService;
import de.eisteemarmela.grocery_system.model.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
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

    @GetMapping( "/brands/delete/{id}" )
    public String deleteBrand( @PathVariable("id") Long id ) {
        brandService.deleteBrandById( id );
        return "redirect:/brands";
    }

    @PostMapping( "brands/add" )
    public String saveBrand( @ModelAttribute("addBrand") Brand brand ) {
        brandService.saveBrand( brand );
        return "redirect:/brands";
    }

    @PostMapping("brands/edit")
    public String editBrand( @RequestParam("brandId") Long id,
                             @RequestParam("brandName") String name){

        Brand brand = brandService.getBrandById( id );
        brand.setName( name );
        brandService.saveBrand( brand );

        return "redirect:/brands";

    }

}

package de.eisteemarmela.grocery_system.model.services;

import de.eisteemarmela.grocery_system.model.entities.Grocery;
import de.eisteemarmela.grocery_system.model.repositories.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    GroceryRepository groceryRepository;

    public GroceryService( GroceryRepository groceryRepository ) {
        this.groceryRepository = groceryRepository;
    }

    public List< Grocery > getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery findById( Long id ) {
        return groceryRepository.findById( id ).orElse( null );
    }

    public Grocery saveGrocery( Grocery grocery ) {
        return groceryRepository.save( grocery );
    }

}

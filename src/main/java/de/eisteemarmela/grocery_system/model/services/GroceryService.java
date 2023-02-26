package de.eisteemarmela.grocery_system.model.services;

import de.eisteemarmela.grocery_system.model.entities.Grocery;
import de.eisteemarmela.grocery_system.model.repositories.GroceryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Grocery getGroceryById( Long id ) {
        return groceryRepository.findById( id ).orElse( null );
    }

    public void saveGrocery( Grocery grocery ) {

        if(grocery.getLastBought() == null) {
            grocery.setLastBought( LocalDate.now() );
        }

        groceryRepository.save( grocery );
    }
    public void deleteGroceryById( double id ) {
        groceryRepository.deleteById( ( long ) id );
    }
}

package de.eisteemarmela.grocery_system.model.services;

import de.eisteemarmela.grocery_system.model.entities.Store;
import de.eisteemarmela.grocery_system.model.repositories.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    StoreRepository storeRepository;

    public StoreService( StoreRepository storeRepository ) {
        this.storeRepository = storeRepository;
    }

    public List< Store > getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreByName( String store ) {
        return storeRepository.findStoreByName( store );
    }
}

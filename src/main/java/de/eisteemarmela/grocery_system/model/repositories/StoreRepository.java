package de.eisteemarmela.grocery_system.model.repositories;

import de.eisteemarmela.grocery_system.model.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository< Store, Long > {

    Store findStoreById( Long id);

}

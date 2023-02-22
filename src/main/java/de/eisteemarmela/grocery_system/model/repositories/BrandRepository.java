package de.eisteemarmela.grocery_system.model.repositories;

import de.eisteemarmela.grocery_system.model.entities.Brand;
import de.eisteemarmela.grocery_system.model.entities.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository< Brand, Long > {

    Brand findBrandByName( String name );

}

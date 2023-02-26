package de.eisteemarmela.grocery_system.model.services;

import de.eisteemarmela.grocery_system.model.entities.Brand;
import de.eisteemarmela.grocery_system.model.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    BrandRepository brandRepository;

    public BrandService( BrandRepository brandRepository ) {
        this.brandRepository = brandRepository;
    }

    public List< Brand > getAllBrands() {
        return brandRepository.findAll();
    }

    public void saveBrand( Brand brand ) {
        brandRepository.save( brand );
    }

    public Brand getBrandById( Long brandId ) {
        return brandRepository.findById( brandId ).orElse( null );
    }
}

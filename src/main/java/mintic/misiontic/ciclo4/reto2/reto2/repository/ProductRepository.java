/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.crudRepository.ProductCrudRepository;
import mintic.misiontic.ciclo4.reto2.reto2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class ProductRepository {
    @Autowired
    ProductCrudRepository productCrudRepository;
    
    public List<Product> getAll(){
        return productCrudRepository.findAll();
    }
    
    public Optional<Product> getProduct(int id){
        return productCrudRepository.findById(id);
    }
    
    public Product save(Product p){
        return productCrudRepository.save(p);
    }
    
    public Product update(Product p){
    Product existente = productCrudRepository.findById(p.getId()).orElse(null);
    existente.setBrand(p.getBrand());
    existente.setCategory(p.getCategory());
    existente.setPresentation(p.getPresentation());
    existente.setDescription(p.getDescription());
    existente.setPrice(p.getPrice());
    existente.setAvailability(p.getAvailability());
    existente.setQuantity(p.getQuantity());
    existente.setPhotography(p.getPhotography());
    return productCrudRepository.save(existente); 
    }
    
    public void deleteProduct(int id){
        productCrudRepository.deleteById(id);
    }
    
    public List<Product> getDescription (String description){
        return productCrudRepository.findByDescriptionLike(description);
    }
    
    public List<Product> getPrice (double price){
        return productCrudRepository.findByPriceLessThanEqual(price);
    }
    
    
}

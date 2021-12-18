/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.crudRepository;

import java.util.List;
import mintic.misiontic.ciclo4.reto2.reto2.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Hiddenpath
 */
public interface ProductCrudRepository extends MongoRepository<Product, Integer>{
    
    public List<Product> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Product> findByDescriptionLike(String description);
}

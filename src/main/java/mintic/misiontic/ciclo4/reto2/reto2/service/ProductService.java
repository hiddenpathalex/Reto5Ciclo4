/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.service;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.model.Product;
import mintic.misiontic.ciclo4.reto2.reto2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    
    public Optional<Product> getProduct(int id){
        return productRepository.getProduct(id);
    }
    
    public Product save(Product p){
        if(p.getId() != null){
            return productRepository.save(p);
        }else{
//            Optional<Product> validar=productRepository.getProduct(p.getId());
//            if(validar.isEmpty()){
//                return productRepository.save(p);
//            }
            return p;
        }
    }
    
    public Product update (Product p){
        return productRepository.update(p);
    }
    
    public void delete(int id){
        productRepository.deleteProduct(id);
    }
    
    public List<Product> getDescription (String description){
        return productRepository.getDescription(description);
    }
    
    public List<Product> getPrice (double price){
        return productRepository.getPrice(price);
    }
    
    
}

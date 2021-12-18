/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.controller;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.model.Product;
import mintic.misiontic.ciclo4.reto2.reto2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hiddenpath
 */

@RestController
@RequestMapping("/api/cleaningprod")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.CREATED)
    public List<Product> getAll(){
        return productService.getAll();
    }
    
    @GetMapping("{id}")
    public Optional<Product> getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save (@RequestBody Product p){
        return productService.save(p);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product p){
        return productService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        productService.delete(id);
    }
    
    @GetMapping("/price/{price}")
    public List<Product> getPrice(@PathVariable("price") double precio){
        return productService.getPrice(precio);
    }
    
    @GetMapping("/description/{description}")
    public List<Product> getDescription(@PathVariable("description") String des){
        return productService.getDescription(des);
    }
    
    
}

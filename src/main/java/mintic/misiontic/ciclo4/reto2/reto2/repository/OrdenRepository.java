/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.crudRepository.OrdenCrudRepository;
import mintic.misiontic.ciclo4.reto2.reto2.model.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class OrdenRepository {
    @Autowired
    OrdenCrudRepository ordenCrudRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Orden> getAll(){
        return (List<Orden>) ordenCrudRepository.findAll();
    }
    
    public Optional<Orden> getOrden(int id){
        return ordenCrudRepository.findById(id);
    }
    
    public Orden save(Orden o){
        return ordenCrudRepository.save(o);
    }
    
    public void update(Orden o){
        ordenCrudRepository.save(o);
    }
    
    public List<Orden> getZone(String zone){
        return ordenCrudRepository.findBySalesManZone(zone);
    }
    
    public List<Orden> getBySalesManId(Integer id){
        return ordenCrudRepository.findBySalesManId(id);
    }
    
    public List<Orden> getBySalesManIdAndStatus(Integer id, String status){
        return ordenCrudRepository.findBySalesManIdAndStatus(id, status);
    }
    
    public List<Orden> getByRegisterDayAndSalesManId (String registerDay, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Orden> orders = mongoTemplate.find(query, Orden.class);

        return orders;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.service;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.model.Orden;
import mintic.misiontic.ciclo4.reto2.reto2.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class OrdenService {
    @Autowired
    OrdenRepository ordenRepository;
    
    public List<Orden> getAll(){
        return ordenRepository.getAll();
    }
    
    public Optional<Orden> getOrder(int id){
        return ordenRepository.getOrden(id);
    }
    
    public Orden save(Orden o){
        if(o.getId() == null){
            return ordenRepository.save(o);
        }else{
            Optional<Orden> validate=ordenRepository.getOrden(o.getId());
            if(validate.isEmpty()){
                return ordenRepository.save(o);
            }
            return o;
        }
    }
    
    public Orden update(Orden order) {
        if (order.getId() != null) {
            Optional<Orden> orden = ordenRepository.getOrden(order.getId());
            if(!orden.isEmpty()) {

                if (order.getId() != null) {
                    orden.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orden.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orden.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orden.get().setQuantities(order.getQuantities());
                }
                ordenRepository.update(orden.get());
                return orden.get();
            }else{
                return order;
            }
        } else {
            return order;
        }
    }
    
    public List<Orden> getZone(String zone){
        return ordenRepository.getZone(zone);
    }
    
    public List<Orden> getBySalesManId(Integer id){
        return ordenRepository.getBySalesManId(id);
    }
    
    public List<Orden> getBySalesManIdAndStatus(Integer id, String status){
        return ordenRepository.getBySalesManIdAndStatus(id, status);
    }
    
    public List<Orden> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return ordenRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }
}

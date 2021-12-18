    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.crudRepository;

import java.util.Date;
import java.util.List;
import mintic.misiontic.ciclo4.reto2.reto2.model.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Hiddenpath
 */
public interface OrdenCrudRepository extends MongoRepository<Orden, Integer> {
    
    List<Orden> findBySalesManZone(String zone);
    List<Orden> findBySalesManId(Integer id);
    List<Orden> findBySalesManIdAndStatus(Integer id, String status);
    List<Orden> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}

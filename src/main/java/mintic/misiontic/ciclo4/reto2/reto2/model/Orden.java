/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo4.reto2.reto2.model;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Hiddenpath
 */
@Document(collection="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {
        
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<Integer, Product> products;
    private Map<Integer, Integer> quantities;
    
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    
}

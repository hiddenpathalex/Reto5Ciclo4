package mintic.misiontic.ciclo4.reto2.reto2.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.crudRepository.UserCrudRepository;
import mintic.misiontic.ciclo4.reto2.reto2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UserRepository {
    @Autowired
    UserCrudRepository userCrudRepository;
    
    public List<User> getAll(){
        return (List<User>)userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public User save(User u){
        return userCrudRepository.save(u);
    }

    public boolean existeEmail (String email){
        Optional<User> usuario =  userCrudRepository.findByEmail(email);
        return usuario.isPresent();
    }

    public  Optional<User> autenticarUsuario(String email, String password){
        
        return userCrudRepository.findByEmailAndPassword(email, password);             
    }

    public User update(User u){
    User existente = userCrudRepository.findById(u.getId()).orElse(null);
    existente.setIdentification(u.getIdentification());
    existente.setName(u.getName());
    existente.setAddress(u.getAddress());
    existente.setCellPhone(u.getCellPhone());
    existente.setEmail(u.getEmail());
    existente.setPassword(u.getPassword());
    existente.setZone(u.getZone());
    existente.setType(u.getType());
    return userCrudRepository.save(existente); 
    }

    public void deleteUser(int id){
        userCrudRepository.deleteById(id);
    }
    
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}

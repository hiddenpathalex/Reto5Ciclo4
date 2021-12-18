package mintic.misiontic.ciclo4.reto2.reto2.crudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import mintic.misiontic.ciclo4.reto2.reto2.model.User;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}

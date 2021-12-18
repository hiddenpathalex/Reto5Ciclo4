package mintic.misiontic.ciclo4.reto2.reto2.service;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo4.reto2.reto2.model.User;
import mintic.misiontic.ciclo4.reto2.reto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return (List<User>)userRepository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    
    public User save(User u){
        if (u.getId() != null) {
            if (existeEmail(u.getEmail()) == false) {
                return userRepository.save(u);
            } else {
                return u;
            }
        } else {
            return u;
        }
        
    }

    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password){
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    } 

    public User update (User u){
        return userRepository.update(u);
    }
    
    public void delete(int id){
        userRepository.deleteUser(id);
    }
    
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}

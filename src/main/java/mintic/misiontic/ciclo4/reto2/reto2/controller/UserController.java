package mintic.misiontic.ciclo4.reto2.reto2.controller;

import java.util.List;
import java.util.Optional;

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

import mintic.misiontic.ciclo4.reto2.reto2.model.User;
import mintic.misiontic.ciclo4.reto2.reto2.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.CREATED)

    public List<User> getAll(){
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save (@RequestBody User u){
        return userService.save(u);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User u){
        return userService.update(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        userService.delete(id);
    }
    
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}

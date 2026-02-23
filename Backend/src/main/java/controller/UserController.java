package controller;

import entity.PostEntity;
import entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.IUserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    //get all the users
    @GetMapping
    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    //get the user by the email
    @GetMapping("/{email}")
    public ResponseEntity<UserEntity> getById(@PathVariable String email){
        return userRepository.findById(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //toggle newsletter subscription
    @PutMapping("/{email}/newsletter")
    public ResponseEntity<UserEntity> toggleNewsletter(@PathVariable String email, @RequestParam boolean subscribe){
        return userRepository.findById(email).map(user -> {
            user.setSubscribedToNewsletter(subscribe);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }).orElse(ResponseEntity.notFound().build());
    }

    //delete account
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email){
        if(userRepository.existsById(email)){
            userRepository.deleteById(email);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

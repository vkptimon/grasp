package controller;

import entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.IUserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    // Get all users
    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String id){
        return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Toggle newsletter subscription
    @PutMapping("/{id}/newsletter")
    public ResponseEntity<UserEntity> toggleNewsletter(@PathVariable String id, @RequestParam boolean subscribe){
        return userRepository.findById(id).map(user -> {
            user.setSubscribedToNewsletter(subscribe);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

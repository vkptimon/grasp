package controller;

import entity.PostEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.IPostRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {
    private final IPostRepository postRepository;

    public PostController(IPostRepository postRepository){
        this.postRepository = postRepository;
    }

    // Get all tutorials
    @GetMapping
    public List<PostEntity> getAllTutorials(){
        return postRepository.findAll();
    }

    // Get tutorials by topic
    @GetMapping("/topic/{topic}")
    public List<PostEntity> getTutorialsByTopic(@PathVariable String topic){
        return postRepository.findByTopic(topic);
    }

    // Get tutorial by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getTutorialById(@PathVariable String id){
        return postRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Create a new tutorial
    @PostMapping
    public PostEntity createTutorial(@RequestBody PostEntity tutorial){
        return postRepository.save(tutorial);
    }

    // Update tutorial status (publish/draft)
    @PutMapping("/{id}/status")
    public ResponseEntity<PostEntity> updateTutorialStatus(@PathVariable String id, @RequestParam String status){
        return postRepository.findById(id).map(tutorial -> {
            tutorial.setStatus(PostStatus.valueOf(status.toUpperCase()));
            postRepository.save(tutorial);
            return ResponseEntity.ok(tutorial);
        }).orElse(ResponseEntity.notFound().build());
    }
}

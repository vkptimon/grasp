package controller;

import entity.PostEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.IPostRepository;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {
    private final IPostRepository postRepository;

    public PostController(IPostRepository postRepository){
        this.postRepository = postRepository;
    }

    // get all post for the feed
    @GetMapping
    public List<PostEntity> getAllPost(){
        return postRepository.findAll();
    }

    // get a post by its id
    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable String id){
        return postRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // create a new post
    @PostMapping
    public PostEntity createPost(@RequestBody PostEntity post){
        return postRepository.save(post);
    }
}

package controller;

import entity.CommentsEntity;
import org.springframework.web.bind.annotation.*;
import repository.ICommentsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
@CrossOrigin(origins = "http://localhost:5173")
public class CommentController {

    private final ICommentsRepository commentRepository;

    public CommentController(ICommentsRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Get all comments for a specific post
    @GetMapping
    public List<CommentsEntity> getCommentsByPost(@PathVariable String postId) {
        return commentRepository.getByPostId(postId);
    }

    // Add a comment to a post
    @PostMapping
    public CommentsEntity addComment(@PathVariable String postId, @RequestBody CommentsEntity comment) {
        comment.setPostId(postId); // Ensure the foreign key is set
        return commentRepository.save(comment);
    }
}

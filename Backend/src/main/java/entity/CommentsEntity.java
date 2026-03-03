package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentsEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentBody; // text type
    
    @Column(nullable = false)
    private Integer postedAt; // comment posted 'x' mins/days/months ago

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Integer getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Integer postedAt) {
        this.postedAt = postedAt;
    }
}

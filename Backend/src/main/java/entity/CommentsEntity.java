package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentsEntity extends BaseEntity{
    private String postId; // FK
    private String userId; // FK
    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentBody; // text type
    @Column(nullable = false)
    private Integer postedAt; // comment posted 'x' mins/days/months ago

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

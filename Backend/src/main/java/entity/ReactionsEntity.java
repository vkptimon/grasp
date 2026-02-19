package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reactions")
public class ReactionsEntity extends BaseEntity{
    private String postId; // referred from PostEntity, FK
    private String userId; // referred from UserEntity, FK
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReactionType reactionType; // like, cheer, insightful are the reaction types for now
    private Integer count;

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

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

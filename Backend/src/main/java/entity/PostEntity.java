package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity{
    @Column(nullable = false)
    private String title;
    private String description;
    private String authorId; // should be referred from the UserEntity
    private Integer estTimeToRead; // 'x' mins to read for a post
    private Integer viewCount; // number of impressions for the post
    @CreatedDate
    @Column(nullable = false)
    private Date publishedAt; // date the article was published on
    private List<CommentsEntity> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Integer getEstTimeToRead() {
        return estTimeToRead;
    }

    public void setEstTimeToRead(Integer estTimeToRead) {
        this.estTimeToRead = estTimeToRead;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentsEntity> comments) {
        this.comments = comments;
    }
}

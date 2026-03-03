package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookmarks")
public class BookmarksEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    private String bookmarkListName; //name of the list, the article will be added to

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public String getBookmarkListName() {
        return bookmarkListName;
    }

    public void setBookmarkListName(String bookmarkListName) {
        this.bookmarkListName = bookmarkListName;
    }
}

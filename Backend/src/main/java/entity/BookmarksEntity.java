package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookmarks")
public class BookmarksEntity extends BaseEntity{
    private String userId; // FK
    private String postId; // FK
    private String bookmarkListName; //name of the list, the article will be added to

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getBookmarkListName() {
        return bookmarkListName;
    }

    public void setBookmarkListName(String bookmarkListName) {
        this.bookmarkListName = bookmarkListName;
    }
}

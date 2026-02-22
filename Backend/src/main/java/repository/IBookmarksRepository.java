package repository;

import entity.BookmarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookmarksRepository extends JpaRepository<BookmarksEntity, String> {
    List<BookmarksEntity> getByUserId(String userId);
}

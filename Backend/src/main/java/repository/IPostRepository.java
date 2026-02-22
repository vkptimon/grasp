package repository;

import entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<PostEntity, String> {
    // will fetch posts based on the authorId
    List<PostEntity> findByAuthor(String authorId);
}

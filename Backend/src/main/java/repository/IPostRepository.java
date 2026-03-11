package repository;

import entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<PostEntity, String> {
    // Find tutorials by topic
    List<PostEntity> findByTopic(String topic);

    // Find tutorials by author
    List<PostEntity> findByAuthorId(String authorId);

    // Find published tutorials
    List<PostEntity> findByStatus(entity.PostStatus status);
}

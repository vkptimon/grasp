package repository;

import entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<TopicEntity, String> {
    // Find tutorials by topic
    List<TopicEntity> findByTopic(String topic);

    // Find tutorials by author
    List<TopicEntity> findByAuthorId(String authorId);

    // Find published tutorials
    List<TopicEntity> findByStatus(entity.PostStatus status);
}

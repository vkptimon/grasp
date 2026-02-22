package repository;

import entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentsRepository extends JpaRepository<CommentsEntity, String> {
    List<CommentsEntity> getByPostId(String postId);
}

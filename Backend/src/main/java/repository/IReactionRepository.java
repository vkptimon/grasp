package repository;

import entity.ReactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReactionRepository extends JpaRepository<ReactionsEntity, String> {
    List<ReactionsEntity> getByPostId(String postId);
}

package repository;

import entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFollowRepository extends JpaRepository<FollowEntity, String> {
    // gets followers
    List<FollowEntity> findByFollowing_Id(String followingId);

    // gets following
    List<FollowEntity> findByFollower_Id(String followerId);
}

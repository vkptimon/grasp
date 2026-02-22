package repository;

import entity.FollowInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFollowInfoRepository extends JpaRepository<FollowInfoEntity, String> {
    // gets followers count
    List<FollowInfoEntity> getCountByFollowingId(String followingId);

    // gets following count
    List<FollowInfoEntity> getCountByFollowerId(String followerId);
}

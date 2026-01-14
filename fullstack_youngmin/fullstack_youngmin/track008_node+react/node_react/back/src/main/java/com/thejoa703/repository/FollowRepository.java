package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long>{ //Entity, pk
	// 1. 팔로우 관계 단건 조회
    Optional<Follow> findByFollower_IdAndFollowee_Id(Long followerId, Long followeeId);

    @EntityGraph(attributePaths = {"followee"})
    List<Follow> findByFollower_Id(Long followerId);

    // 3. 팔로워 목록 조회 (나를 팔로우하는 사람들 정보까지 가져오기)
    // 지연 로딩 방지를 위해 follower 엔티티를 함께 조회합니다.
    @EntityGraph(attributePaths = {"follower"})
    List<Follow> findByFollowee_Id(Long followeeId);

    // 4. 팔로잉 수 집계 (내가 팔로우 하는 사람 수)
    long countByFollower_Id(Long followerId);

    // 5. 팔로워 수 집계 (나를 팔로우 하는 사람 수)
    long countByFollowee_Id(Long followeeId);
}






/*
CREATE : save     -  INSERT INTO appuser (컬럼1,컬럼2,,) values (?,?,,) 
READ   : findAll  -  SELETE * from appuser
         findById -  SELETE * from appuser where id=?
UPDATE : save     -  update appuser set 컬럼1=? ,컬럼2=? where id=? 
DELETE : deleteById   - delete from appuser where id=?
 */
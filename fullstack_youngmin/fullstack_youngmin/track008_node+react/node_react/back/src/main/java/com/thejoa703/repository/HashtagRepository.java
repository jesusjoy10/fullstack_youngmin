package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long>{ //Entity, pk
	// 해쉬태그 키워드를 넣어주면 post에서 join해서 데이터 가져오기 > join sql 구문 찾기
	@Query("SELECT  h FROM Hashtag h JOIN FETCH h.posts WHERE h.name=:name")
	Optional<Hashtag>findByNameWithPosts(@Param("name")String name);
	//import org.springframework.data.repository.query.Param;
	//import java.util.Optional
}

/*
CREATE : save     -  INSERT INTO appuser (컬럼1,컬럼2,,) values (?,?,,) 
READ   : findAll  -  SELETE * from appuser
         findById -  SELETE * from appuser where id=?
UPDATE : save     -  update appuser set 컬럼1=? ,컬럼2=? where id=? 
DELETE : deleteById   - delete from appuser where id=?
 */
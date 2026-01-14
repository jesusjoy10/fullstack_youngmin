package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{ //Entity, pk

}

/*
CREATE : save     -  INSERT INTO appuser (컬럼1,컬럼2,,) values (?,?,,) 
READ   : findAll  -  SELETE * from appuser
         findById -  SELETE * from appuser where id=?
UPDATE : save     -  update appuser set 컬럼1=? ,컬럼2=? where id=? 
DELETE : deleteById   - delete from appuser where id=?
 */
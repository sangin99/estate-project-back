package com.estate.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estate.back.entity.BoardEntity;

// Estate 데이터베이스의 board 테이블의 작업을 위한 리포지토리
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    
    List<BoardEntity> findByOrderByReceptionNumberDesc();
    // Contains / Containing / isContaining => LIKE '%word%'
    // StartingWith => LIKE 'word%'
    // EndingWith => LIKE '%word'
    List<BoardEntity> findByTitleContainsOrderByReceptionNumberDesc(String title);
    BoardEntity findByReceptionNumber(Integer receptionNumber);

}

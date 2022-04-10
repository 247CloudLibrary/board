package com.cloudlibrary.board.infrastructure.persistence.mysql.repository;


import com.cloudlibrary.board.application.domain.Board;
import com.cloudlibrary.board.infrastructure.persistence.mysql.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long> {

    @Query("SELECT board FROM BoardEntity board ORDER BY board.id DESC")
    List<Board> findAllBoardDesc();
}

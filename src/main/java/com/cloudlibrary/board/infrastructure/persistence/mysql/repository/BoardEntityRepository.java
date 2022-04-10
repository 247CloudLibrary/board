package com.cloudlibrary.board.infrastructure.persistence.mysql.repository;

import com.cloudlibrary.board.application.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardEntityRepository extends JpaRepository<Board, Long> {
}

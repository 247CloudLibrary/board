package com.cloudlibrary.board.application.service;


import com.cloudlibrary.board.infrastructure.persistence.mysql.repository.BoardEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardService implements BoardReadUseCase{

    private final BoardEntityRepository boardEntityRepository;

    @Autowired
    public BoardService(BoardEntityRepository boardEntityRepository) {
        this.boardEntityRepository = boardEntityRepository;
    }


    @Override
    public FindBoardResult getBoard(BoardFindQuery query) {

        return null;
    }

    @Transactional(readOnly=true)
    @Override
    public List<FindBoardResult> getBoardAllList() {
        return boardEntityRepository.findAllBoardDesc().stream().map(FindBoardResult::findByBoard).collect(Collectors.toList());
    }
}

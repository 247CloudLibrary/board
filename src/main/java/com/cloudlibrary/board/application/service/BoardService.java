package com.cloudlibrary.board.application.service;


import com.cloudlibrary.board.application.domain.Board;
import com.cloudlibrary.board.exception.CloudLibraryException;
import com.cloudlibrary.board.exception.MessageType;
import com.cloudlibrary.board.infrastructure.persistence.mysql.entity.BoardEntity;
import com.cloudlibrary.board.infrastructure.persistence.mysql.repository.BoardEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardService implements BoardReadUseCase{

    private final BoardEntityRepository boardEntityRepository;

    @Autowired
    public BoardService(BoardEntityRepository boardEntityRepository) {
        this.boardEntityRepository = boardEntityRepository;
    }

    /**
     * @exception CloudLibraryException MessageType.NOT_FOUND 게시글 찾을 수 없음
     */
    @Override
    public FindBoardResult getBoard(BoardFindQuery query) {

        Optional<Board> result = boardEntityRepository.findById(query.getBoardId()).stream().map(BoardEntity::toBoard).findFirst();

        if(result.isEmpty()){
            throw new CloudLibraryException(MessageType.NOT_FOUND);
        }

       return FindBoardResult.findByBoard(result.get());
    }

    @Transactional(readOnly=true)
    @Override
    public List<FindBoardResult> getBoardAllList() {

        return boardEntityRepository.findAllBoardDesc().stream().map(FindBoardResult::findByBoard).collect(Collectors.toList());
    }
}

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
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardService implements BoardReadUseCase,BoardOperationUseCase{

    private final BoardEntityRepository boardEntityRepository;

    @Autowired
    public BoardService(BoardEntityRepository boardEntityRepository) {
        this.boardEntityRepository = boardEntityRepository;
    }

    /**
     * @throws CloudLibraryException MessageType.NOT_FOUND 게시글 찾을 수 없음
     * boardEntity.increaseHits() --> 게시글 조회할 때마다 readcount 1씩 증가
     */
    @Override
    @Transactional
    public FindBoardResult getBoard(BoardFindQuery query) {

        BoardEntity boardEntity = boardEntityRepository.findById(query.getBoardId()).orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));
        boardEntity.increaseHits();

        Board result = boardEntity.toBoard();

       return FindBoardResult.findByBoard(result);

    }

    @Transactional(readOnly=true)
    @Override
    public List<FindBoardResult> getBoardAllList() {

        return boardEntityRepository.findAllBoardDesc().stream().map(FindBoardResult::findByBoard).collect(Collectors.toList());
    }


    /**
     *TODO adminId, adminName 추가
     */
    @Override
    @Transactional
    public void createBoard(BoardCreateCommand command) {
        Board board = Board.builder()
                .title(command.getTitle())
                .contents(command.getContents())
                .libraryName(command.getLibraryName())
                .type(command.getType())
                .build();

        boardEntityRepository.save(new BoardEntity(board));
    }

    @Override
    @Transactional
    public FindBoardResult updateBoard(BoardUpdateCommand command) {

        BoardEntity boardEntity = boardEntityRepository.findById(command.getId()).stream().findAny().orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        Board updateContent = Board.builder()
                .title(command.getTitle())
                .contents(command.getContents())
                .libraryName(command.getLibraryName())
                .type(command.getType())
                .build();

        boardEntity.update(updateContent);

        Board result = boardEntity.toBoard();

        return FindBoardResult.findByBoard(result);

    }


    @Override
    public void deleteBoard(BoardDeleteCommand command) {
        BoardEntity board = boardEntityRepository.findById(command.getId())
                .orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        boardEntityRepository.delete(board);
    }
}

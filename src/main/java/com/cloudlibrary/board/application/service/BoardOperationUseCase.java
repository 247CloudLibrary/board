package com.cloudlibrary.board.application.service;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

public interface BoardOperationUseCase {

    void createBoard(BoardCreateCommand command);
    BoardReadUseCase.FindBoardResult updateBoard(BoardUpdateCommand command);
    void deleteBoard(BoardDeleteCommand command);

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BoardCreateCommand {
        private final long adminId;
        private final String type;
        private final String title;
        private final String contents;
        private final String libraryName;
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BoardUpdateCommand {
        private final long id;
        private final long adminId;
        private final String type;
        private final String title;
        private final String contents;
        private final String libraryName;

    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BoardDeleteCommand {
        private final long id;
    }
}

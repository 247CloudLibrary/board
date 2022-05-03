package com.cloudlibrary.board.application.service;

import com.cloudlibrary.board.application.domain.Board;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardReadUseCase {

    FindBoardResult getBoard(BoardFindQuery query);

    List<FindBoardResult> getBoardAllList();


    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BoardFindQuery {
        private Long boardId;

        public BoardFindQuery(Long boardId) {
            this.boardId = boardId;
        }
    }

    @Getter
    @ToString
    @Builder
    class FindBoardResult {
        private final long id;
        private final long adminId;
        private final String type;
        private final String title;
        private final String contents;
        private final String libraryName;
        private final long readCounts;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;


        public static FindBoardResult findByBoard(Board board) {
            return FindBoardResult.builder()
                    .id(board.getId())
                    .adminId(board.getAdminId())
                    .type(board.getType())
                    .title(board.getTitle())
                    .contents(board.getContents())
                    .libraryName(board.getLibraryName())
                    .readCounts(board.getReadCounts())
                    .createdAt(board.getCreatedAt())
                    .updatedAt(board.getUpdatedAt())
                    .build();


        }

    }
}

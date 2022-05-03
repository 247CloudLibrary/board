package com.cloudlibrary.board.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class Board {
    private final long id;
    private final long adminId;
    private final String type;
    private final String title;
    private final String contents;
    private final String libraryName;
    private final Long readCounts;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}

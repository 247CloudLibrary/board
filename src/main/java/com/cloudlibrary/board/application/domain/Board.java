package com.cloudlibrary.board.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

@Getter
@ToString
@Builder
public class Board {
    private final long id;
    private final long adminId;
    private final String adminName;
    private final String type;
    private final String title;
    private final String contents;
    private final String libraryName;
    private final Long readCounts;

}

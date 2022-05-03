package com.cloudlibrary.board.ui.view.board;

import com.cloudlibrary.board.application.service.BoardReadUseCase;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;



@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardView {
    @ApiModelProperty(value= "Board ID")
    private final long id;
    @ApiModelProperty(value="작성자 id")
    private final long adminId;
    @ApiModelProperty(value="작성자의 소속 도서관")
    private final String libraryName;
    @ApiModelProperty(value="게시글 타입")
    private final String type;
    @ApiModelProperty(value="게시글 제목")
    private final String title;
    @ApiModelProperty(value="게시글 내용")
    private final String contents;
    @ApiModelProperty(value="조회수")
    private final long readCounts;
    @ApiModelProperty(value="작성일자")
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private final LocalDateTime createdAt;
    @ApiModelProperty(value="수정일자")
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private final LocalDateTime updatedAt;

    public BoardView(BoardReadUseCase.FindBoardResult result) {
        this.id = result.getId();
        this.adminId =result.getAdminId();
        this.libraryName= result.getLibraryName();
        this.type = result.getType();
        this.title = result.getTitle();
        this.contents = result.getContents();
        this.readCounts = result.getReadCounts();
        this.createdAt = result.getCreatedAt();
        this.updatedAt = result.getUpdatedAt();
    }

}

package com.cloudlibrary.board.ui.view.board;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;



@Builder //추후 삭제
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardView {
    @ApiModelProperty(value= "Board ID")
    private final long id;
    @ApiModelProperty(value="작성자 id")
    private final long adminId;
    @ApiModelProperty(value="게시글 타입")
    private final String type;
    @ApiModelProperty(value="게시글 제목")
    private final String title;
    @ApiModelProperty(value="작성자의 소속 도서관")
    private final String libraryName;
    @ApiModelProperty(value="작성자 이름")
    private final String adminName;
    @ApiModelProperty(value="게시글 내용")
    private final String contents;
    @ApiModelProperty(value="조회수")
    private final Long readCounts;


}

package com.cloudlibrary.board.ui.requestBody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardUpdateRequest {

    private Long adminId;

    @NotEmpty(message = "타입 지정 필수입니다")
    private String type;

    @NotEmpty(message="제목은 필수입니다")
    private String title;

    @NotEmpty(message = "내용은 필수입니다")
    private String contents;

    private String libraryName;
}

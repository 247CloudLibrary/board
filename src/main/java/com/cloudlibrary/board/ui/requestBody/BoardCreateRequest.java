package com.cloudlibrary.board.ui.requestBody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardCreateRequest {
    private String type;
    private String title;
    private String contents;
    private String libraryName;
}

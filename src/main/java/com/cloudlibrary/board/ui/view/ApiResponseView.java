package com.cloudlibrary.board.ui.view;

import com.cloudlibrary.board.ui.view.board.BoardView;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseView<T> {
    private final T data;

    public ApiResponseView(T data) {
        this.data = data;
    }
}

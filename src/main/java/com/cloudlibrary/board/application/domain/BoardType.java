package com.cloudlibrary.board.application.domain;


import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

@Getter
public enum BoardType {
    NOTICE("공지사항"),
    INFO("안내사항"),
    INVALID("유효하지않음");

    private final String type;

    BoardType(String type) {
        this.type = type;
    }

    public static BoardType find(String name) {

        if (ObjectUtils.isEmpty(name)) {
            return INVALID;
        }

        for (BoardType type : BoardType.values()) {
            if (type.name().equals(name.toUpperCase())) {
                return type;
            }
        }
        return INVALID;
    }
}


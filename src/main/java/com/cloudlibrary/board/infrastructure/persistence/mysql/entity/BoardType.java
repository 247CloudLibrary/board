package com.cloudlibrary.board.infrastructure.persistence.mysql.entity;


import lombok.Getter;

import java.util.Objects;

/**
 * NOTICE 공지사항
 * INFO 안내사항
 */

@Getter
public enum BoardType {
    NOTICE,
    INFO

}


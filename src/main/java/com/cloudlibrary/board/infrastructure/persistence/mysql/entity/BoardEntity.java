package com.cloudlibrary.board.infrastructure.persistence.mysql.entity;


import com.cloudlibrary.board.application.domain.Board;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long adminId;

    private String adminName;

    private String libraryName;

    private String type;

    @NotNull
    @Column(length = 500)
    private String title;

    @NotNull
    @Column(length = 500)
    private String contents;

    private long readCounts;


    public Board toBoard(){
        return Board.builder()
                .id(this.id)
                .adminId(this.adminId)
                .adminName(this.adminName)
                .libraryName(this.libraryName)
                .type(this.type)
                .title(this.title)
                .contents(this.contents)
                .readCounts(this.readCounts)
                .build();

    }

    public BoardEntity(Board board) {
        this.id = board.getId();
        this.adminId = board.getAdminId();
        this.adminName = board.getAdminName();
        this.libraryName = board.getLibraryName();
        this.type = board.getType();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.readCounts= board.getReadCounts();

    }
}

package com.cloudlibrary.board.infrastructure.persistence.mysql.entity;


import com.cloudlibrary.board.application.domain.Board;
import com.cloudlibrary.board.application.domain.BoardType;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(nullable = false)
    private long adminId;

//    @Column(nullable = false)
    private String adminName;

    @Column(nullable = false)
    private String libraryName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType type;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @ColumnDefault("0")
    private long readCounts;


    public Board toBoard(){
        return Board.builder()
                .id(this.id)
                .adminId(this.adminId)
                .adminName(this.adminName)
                .libraryName(this.libraryName)
                .type(this.type.getType())
                .title(this.title)
                .contents(this.contents)
                .readCounts(this.readCounts)
                .createdAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt())
                .build();

    }

    public BoardEntity(Board board) {
        this.adminId = board.getAdminId();
        this.adminName = board.getAdminName();
        this.libraryName = board.getLibraryName();
        this.type = BoardType.find(board.getType());
        this.title = board.getTitle();
        this.contents = board.getContents();

    }

    /**
     * 조회 수 증가
     */
    public void increaseHits(){
        this.readCounts++;
    }


    /**
     * 게시글 수정
     */
    public void update(Board board){
        this.libraryName = board.getLibraryName();
        this.type = BoardType.find(board.getType());
        this.title = board.getTitle();
        this.contents = board.getContents();
    }
}

package com.cloudlibrary.board.ui.controller;

import com.cloudlibrary.board.ui.requestBody.BoardCreateRequest;
import com.cloudlibrary.board.ui.requestBody.BoardUpdateRequest;
import com.cloudlibrary.board.ui.view.ApiResponseView;
import com.cloudlibrary.board.ui.view.board.BoardView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@Api(value="보드 API")
@RequestMapping("/v1/boards")
public class BoardController {

    @PostMapping("")
    @ApiOperation("게시글 등록")
    public ResponseEntity<ApiResponseView<BoardView>> createBoards(@RequestBody BoardCreateRequest request){

        //도서관이 null일때도 생각하기

        BoardView mockResult = BoardView.builder()
                .type(request.getTitle())
                .title(request.getType())
                .contents(request.getContents())
                .adminName("관리자")
                .libraryName(request.getLibraryName())
                .createdAt(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(new ApiResponseView<>(mockResult));
    }

    @GetMapping("")
    @ApiOperation("게시글 목록 조회")
    public ResponseEntity<ApiResponseView<List<BoardView>>> getBoardsAll() {
        ArrayList<BoardView> boardList = new ArrayList<>();

        BoardView mockResult = BoardView.builder()
                .id(0)
                .adminId(2L)
                .adminName("관리자")
                .type("공지사항")
                .title("API테스트용 게시글 제목")
                .contents("API테스트용 게시글 내용")
                .libraryName("별빛도서관")
                .readCounts(10L)
                .createdAt(LocalDateTime.of(2022, 3, 2, 18, 32, 0))
                .updatedAt(LocalDateTime.of(2022, 3, 3, 18, 32, 0))
                .build();
        boardList.add(mockResult);

        BoardView mockResult2 = BoardView.builder()
                .id(1)
                .adminId(3L)
                .adminName("관리자")
                .type("공지사항2")
                .title("API테스트용 게시글 제목2")
                .contents("API테스트용 게시글 내용2")
                .libraryName("별빛도서관2")
                .createdAt(LocalDateTime.of(2022, 3, 2, 18, 32, 0))
                .updatedAt(LocalDateTime.of(2022, 3, 3, 18, 32, 0))
                .readCounts(10L).build();
        boardList.add(mockResult2);

        return ResponseEntity.ok(new ApiResponseView<>(boardList));
    }

    @GetMapping("/{id}")
    @ApiOperation("게시글 상세 조회")
    public ResponseEntity<ApiResponseView<BoardView>> getBoard(@PathVariable("id") Long id){
        BoardView mockResult = BoardView.builder()
                .id(id)
                .adminId(2L)
                .adminName("관리자")
                .type("공지사항")
                .title("API테스트용 게시글 제목")
                .contents("API테스트용 게시글 내용")
                .libraryName("별빛도서관")
                .readCounts(10L)
                .createdAt(LocalDateTime.of(2022, 3, 2, 18, 32, 0))
                .updatedAt(LocalDateTime.of(2022, 3, 3, 18, 32, 0))
                .build();
        return ResponseEntity.ok(new ApiResponseView<>(mockResult));
    }

    @PutMapping("/{id}")
    @ApiOperation("게시글 수정")
    public ResponseEntity<ApiResponseView<BoardView>> updateBoard(@PathVariable("id") Long id, @RequestBody BoardUpdateRequest request){

        BoardView mockResult = BoardView.builder()
                .id(id)
                .adminId(2L)
                .adminName("관리자")
                .type(request.getType())
                .title(request.getTitle())
                .contents(request.getContents())
                .libraryName("별빛도서관")
                .updatedAt(LocalDateTime.now())
                .readCounts(10L).build();

        return ResponseEntity.ok(new ApiResponseView<>(mockResult));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("게시글 삭제")
    public ResponseEntity<ApiResponseView<Long>> deleteBoard(@PathVariable("id") Long id){

       return ResponseEntity.ok(new ApiResponseView<>(id));
    }
}


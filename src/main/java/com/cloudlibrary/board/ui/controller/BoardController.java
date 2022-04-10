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

import java.util.List;

@Slf4j
@RestController
@Api(value="보드 API")
@RequestMapping("/v1/boards")
public class BoardController {

    @PostMapping("")
    @ApiOperation("게시글 등록")
    public ResponseEntity<ApiResponseView<Void>> createBoards(@RequestBody BoardCreateRequest request){


        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    @ApiOperation("게시글 목록 조회")
    public ResponseEntity<ApiResponseView<List<BoardView>>> getBoardsAll() {



        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    @ApiOperation("게시글 상세 조회")
    public ResponseEntity<ApiResponseView<BoardView>> getBoard(@PathVariable("id") Long id){

        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    @ApiOperation("게시글 수정")
    public ResponseEntity<ApiResponseView<BoardView>> updateBoard(@PathVariable("id") Long id, @RequestBody BoardUpdateRequest request){


        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    @ApiOperation("게시글 삭제")
    public ResponseEntity<ApiResponseView<Long>> deleteBoard(@PathVariable("id") Long id){

        return ResponseEntity.ok().build();
    }
}


package com.cloudlibrary.board.ui.controller;

import com.cloudlibrary.board.application.service.BoardOperationUseCase;
import com.cloudlibrary.board.application.service.BoardReadUseCase;

import com.cloudlibrary.board.exception.CloudLibraryException;
import com.cloudlibrary.board.exception.MessageType;
import com.cloudlibrary.board.infrastructure.persistence.mysql.entity.BoardType;

import com.cloudlibrary.board.infrastructure.feign.response.AdminResponse;
import com.cloudlibrary.board.infrastructure.feign.service.FeignAdminService;

import com.cloudlibrary.board.ui.requestBody.BoardCreateRequest;
import com.cloudlibrary.board.ui.requestBody.BoardUpdateRequest;
import com.cloudlibrary.board.ui.view.ApiResponseView;
import com.cloudlibrary.board.ui.view.board.BoardView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*")
@Slf4j
@RestController
@Api(value="보드 API")
@RequestMapping("/v1/boards")
public class BoardController {

    private final BoardReadUseCase boardReadUseCase;
    private final BoardOperationUseCase boardOperationUseCase;

    private final FeignAdminService feignAdminService;

    @Autowired
    public BoardController(BoardReadUseCase boardReadUseCase, BoardOperationUseCase boardOperationUseCase, FeignAdminService feignAdminService) {
        this.boardReadUseCase = boardReadUseCase;
        this.feignAdminService = feignAdminService;
        this.boardOperationUseCase = boardOperationUseCase;
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("health-check");
    }

    /**
     * TODO 회원 정보, 도서관 이름 가져오기
     *
     * request가 null이라면 CloudLibraryException 발생
     * 필수값((제목, 내용) 다 입력되었는지 validation check
     */
    @PostMapping("")
    @ApiOperation("게시글 등록")
    public ResponseEntity<Void> createBoard(@Valid @RequestBody BoardCreateRequest request){

        if(ObjectUtils.isEmpty(request)){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        /**
         * request --> create command로 변환
         */
        var command = BoardOperationUseCase.BoardCreateCommand.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .libraryName(request.getLibraryName())
                .type(BoardType.valueOf(request.getType().toUpperCase()).name())
                .build();


        boardOperationUseCase.createBoard(command);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    @ApiOperation("게시글 목록 조회")
    public ResponseEntity<ApiResponseView<List<BoardView>>> getBoardsAll() {
        var results = boardReadUseCase.getBoardAllList();

        return ResponseEntity.ok(new ApiResponseView<>(results.stream().map(BoardView::new).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    @ApiOperation("게시글 상세 조회")
    public ResponseEntity<ApiResponseView<BoardView>> getBoard(@PathVariable("id") Long id){
        var query = new BoardReadUseCase.BoardFindQuery(id);

        var result = boardReadUseCase.getBoard(query);

        return ResponseEntity.ok(new ApiResponseView<>(new BoardView(result)));

    }

    /**
     *
     * TODO 회원 정보, 도서관 이름 가져오기
     */

    @PutMapping("/{id}")
    @ApiOperation("게시글 수정")
    public ResponseEntity<ApiResponseView<BoardView>> updateBoard(@PathVariable("id") Long id,@Valid @RequestBody BoardUpdateRequest request){

        if(ObjectUtils.isEmpty(request)){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        var command =BoardOperationUseCase.BoardUpdateCommand.builder()
                .id(id)
                .title(request.getTitle())
                .contents(request.getContents())
                .libraryName(request.getLibraryName())
                .type(BoardType.valueOf(request.getType().toUpperCase()).name())
                .build();

        var result = boardOperationUseCase.updateBoard(command);


        return ResponseEntity.ok(new ApiResponseView<>(new BoardView(result)));

    }

    /**
     *
     * TODO 회원 정보 가져오기
     */
    @DeleteMapping("/{id}")
    @ApiOperation("게시글 삭제")
    public ResponseEntity<ApiResponseView<Long>> deleteBoard(@PathVariable("id") Long id){

        return ResponseEntity.ok().build();
    }
}


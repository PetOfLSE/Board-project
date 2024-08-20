package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    // 1. 게시글 조회
    @GetMapping("/board")
    public ResponseEntity<List<Board>> index(){
        List<Board> allBoards = boardService.index();
        return ResponseEntity.status(HttpStatus.OK).body(allBoards);
    }

    // 2. 게시글 추가
    @PostMapping("/board")
    public ResponseEntity<Board> add(@RequestBody BoardDTO dto){
        Board board = boardService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    // 3. 게시글 수정
    @PatchMapping("/board/{id}")
    public ResponseEntity<String> patch(@PathVariable Long id, @RequestBody BoardDTO dto){
        Board board = boardService.patch(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body("게시글이 수정되었습니다.");
    }

    // 4. 게시글 삭제
    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Board board = boardService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("삭제가 완료 되었습니다.");
    }
}

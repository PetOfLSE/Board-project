package com.example.board.controller;

import com.example.board.dto.CommentDTO;
import com.example.board.entity.Comment;
import com.example.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 전체 조회
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> show(){
        List<Comment> allComment = commentService.show();
        return ResponseEntity.status(HttpStatus.OK).body(allComment);
    }

    // 댓글 생성
    @PostMapping("/comments/{board_id}")
    public ResponseEntity<String> addComment(@PathVariable Long board_id, @RequestBody CommentDTO dto){
        Comment comment = commentService.addComment(board_id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment.getName() + "님의 댓글이 추가되었습니다.");
    }

    // 댓글 삭제
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        boolean bool = commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("댓글이 삭제되었습니다.");
    }

    // 댓글 수정
    @PatchMapping("/comment/{id}")
    public ResponseEntity<String> patchComment(@PathVariable Long id, @RequestBody CommentDTO dto){
        Comment comment = commentService.patchComment(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body("댓글 수정이 완료되었습니다.");
    }
}

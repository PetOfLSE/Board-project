package com.example.board.dto;

import com.example.board.entity.Board;
import com.example.board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long board_id;
    private Long id;
    private String body;
    private String name;

    public Comment toEntity(Board board){
        return new Comment(null, board, name, body);
    }
}

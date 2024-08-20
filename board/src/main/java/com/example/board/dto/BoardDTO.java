package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String body;

    public Board toEntity(){
        return new Board(id, title, body);
    }
}

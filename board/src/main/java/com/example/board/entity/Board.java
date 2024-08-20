package com.example.board.entity;

import com.example.board.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String body;

    public void patch(BoardDTO dto) {
        if(this.body != dto.getBody()){
            this.body = dto.getBody();
        }
        if(this.title != dto.getTitle()){
            this.title = dto.getTitle();
        }
    }
}

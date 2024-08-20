package com.example.board.entity;

import com.example.board.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column
    private String name;

    @Column
    private String body;

    public void patch(CommentDTO dto) {
        if(this.name != dto.getName()){
            this.name = dto.getName();
        }

        if(this.body != dto.getBody()){
            this.body = dto.getBody();
        }
    }
}

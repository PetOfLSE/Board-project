package com.example.board.service;

import com.example.board.dto.CommentDTO;
import com.example.board.entity.Board;
import com.example.board.entity.Comment;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public List<Comment> show() {
        List<Comment> allComment = commentRepository.findAll();
        return allComment;
    }

    @Transactional
    public Comment addComment(Long boardId, CommentDTO dto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()->new RuntimeException("Board Not Found"));

        Comment comment = dto.toEntity(board);

        Comment save = commentRepository.save(comment);
        return save;
    }

    @Transactional
    public boolean delete(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment != null){
            commentRepository.delete(comment);
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public Comment patchComment(Long id, CommentDTO dto) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment != null){
            comment.patch(dto);
            commentRepository.save(comment);
            return comment;
        }else{
            throw new EntityNotFoundException("댓글을 찾을 수 없습니다.");
        }
    }
}

package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> index() {
        List<Board> allBoard = boardRepository.findAll();
        return allBoard;
    }

    public Board add(BoardDTO dto) {
        Board board = dto.toEntity();
        Board save = boardRepository.save(board);
        return save;
    }

    public Board patch(Long id, BoardDTO dto) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isPresent()){
            Board board = byId.get();
            board.patch(dto);
            Board save = boardRepository.save(board);

            return save;
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    public Board delete(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isPresent()){
           Board board = byId.get();
           boardRepository.delete(board);
           return board;
        }
        else{
            throw new EntityNotFoundException();
        }
    }
}

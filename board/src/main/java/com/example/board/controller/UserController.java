package com.example.board.controller;

import com.example.board.dto.UserDTO;
import com.example.board.entity.User;
import com.example.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/register")
    public User register(@RequestBody UserDTO dto){
        return userService.register(dto);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO dto){
        boolean bool = userService.login(dto);
        if(bool){
            return ResponseEntity.status(HttpStatus.OK).body("로그인이 완료되었습니다.");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인이 실패되었습니다.");
        }
    }
}

package com.example.board.service;

import com.example.board.dto.UserDTO;
import com.example.board.entity.User;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원가입
    public User register(UserDTO dto) {
        User user = dto.toEntity();
        return userRepository.save(user);
    }

    // 로그인
    public boolean login(UserDTO dto) {
        User user = dto.toEntity();
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if(byEmail.isPresent()){
            User getUser = byEmail.get();
            if(getUser.getPassword().equals(user.getPassword())){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}

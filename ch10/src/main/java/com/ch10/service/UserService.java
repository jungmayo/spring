package com.ch10.service;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void insertUser(UserDTO userDTO) {
        //회원가입
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        User user = userDTO.toEntity();
        userRepository.save(user);
    }
    public UserDTO selectUser(String uid) {
        // 사용자 있는지 확인 여부 + 조회
        Optional<User> optUser = userRepository.findById(uid);

        if(optUser.isPresent()) {
            User user = optUser.get();
            return user.toDTO();
        }
        return null;
    }
}

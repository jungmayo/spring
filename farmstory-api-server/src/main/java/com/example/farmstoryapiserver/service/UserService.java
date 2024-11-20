package com.example.farmstoryapiserver.service;

import com.example.farmstoryapiserver.dto.UserDTO;
import com.example.farmstoryapiserver.entity.User;
import com.example.farmstoryapiserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserDTO save(UserDTO userDTO) {

        String encodedPass = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encodedPass);

        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDTO.class);
    }

}
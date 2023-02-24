package com.example.spring_security.service;

import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserRepository;
import com.example.spring_security.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final ObjectMapper objectMapper;

  public void createUser(UserDto userDto) {
    User user = objectMapper.convertValue(userDto, User.class);
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(user);
    userDto.setId(user.getId());
    log.info("User is create");
  }

  public boolean hasUserByName(String name) {
    return userRepository.existsUserByName(name);
  }

}

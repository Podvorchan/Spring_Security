package com.example.spring_security.security;

import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User byName = userRepository.findFirstByName(username)
        .orElseThrow(EntityNotFoundException::new);

    Set<GrantedAuthority> roles = new HashSet<>();
    roles.add(new SimpleGrantedAuthority(byName.getUserRole().name()));

    return new org.springframework.security.core.userdetails.User(byName.getName(),
        byName.getPassword(), roles);
  }
}

package com.example.spring_security.dto;

import com.example.spring_security.api.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private Integer id;

  private String name;

  private String password;

  private UserRole role;

}

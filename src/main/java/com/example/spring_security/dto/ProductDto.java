package com.example.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  private Integer id;

  private String name;

  private Double cost;

}

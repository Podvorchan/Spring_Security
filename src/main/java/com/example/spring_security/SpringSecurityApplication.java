package com.example.spring_security;

import static com.example.spring_security.api.UserRole.ADMIN;
import static com.example.spring_security.api.UserRole.USER;

import com.example.spring_security.dto.ProductDto;
import com.example.spring_security.dto.UserDto;
import com.example.spring_security.service.ProductService;
import com.example.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityApplication {

  private final ProductService productService;
  private final UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void start() {
    ProductDto cocaCola = new ProductDto(1, "Coca-Cola", 38.50);
    ProductDto pepsi = new ProductDto(2, "Pepsi", 40.0);
    ProductDto borgomi = new ProductDto(3, "Borgomi", 69.3);
    ProductDto redBull = new ProductDto(4, "RedBull", 59.0);
    productService.addProduct(cocaCola);
    productService.addProduct(pepsi);
    productService.addProduct(borgomi);
    productService.addProduct(redBull);
    UserDto admin = new UserDto(null, "admin", "admin", ADMIN);
    UserDto user = new UserDto(null, "user", "user", USER);
    userService.createUser(admin);
    userService.createUser(user);

  }
}

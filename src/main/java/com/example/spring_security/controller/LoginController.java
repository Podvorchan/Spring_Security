package com.example.spring_security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {

  @GetMapping("login")
  public String login() {
    log.info("Login page");
    return "login";
  }

  @GetMapping("403")
  public String error403() {
    log.info("Login page");
    return "403Error";
  }

}

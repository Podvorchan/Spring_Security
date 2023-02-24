package com.example.spring_security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@RestController
@RequestMapping("ping")
@RequiredArgsConstructor
@Slf4j
public class PingController {

  @GetMapping
  public String ping() {
    log.info("Ping");
    return "OK";
  }

}

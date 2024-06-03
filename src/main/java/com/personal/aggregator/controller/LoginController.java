package com.personal.aggregator.controller;

import com.personal.aggregator.model.UserDto;
import com.personal.aggregator.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String saveUser(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            log.info("Principal exists");
            UserDto user = new UserDto();
            user.setName(principal.getAttribute("name"));
            user.setEmail(principal.getAttribute("email"));
            userService.save(user);
        }
        return "home";
    }
}

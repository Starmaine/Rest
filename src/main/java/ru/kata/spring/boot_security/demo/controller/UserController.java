package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.converter.UserConverter;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@RestController
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    //    private final UserErrorResponse userErrorResponse; //todo
    private final UserConverter userConverter;

    public UserController(UserService userService /*UserErrorResponse userErrorResponse*/, UserConverter userConverter) {
        this.userService = userService;
//        this.userErrorResponse = userErrorResponse;
        this.userConverter = userConverter;
    }

    @GetMapping("api/v1/user")
    public UserDTO userPage(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        System.out.println(user);
        UserDTO dto = userConverter.convertToDTO(user);
        System.out.println(dto);
        return dto;
    }
}

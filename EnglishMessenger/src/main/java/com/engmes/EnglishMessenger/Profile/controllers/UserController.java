package com.engmes.EnglishMessenger.Profile.controllers;

import com.engmes.EnglishMessenger.Profile.model.User;
import com.engmes.EnglishMessenger.Profile.repository.UserRepository;
import com.engmes.EnglishMessenger.Profile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/user/email")
    public ResponseEntity<String> getUsername(@RequestBody String email) {
        Optional<User> user = userService.findByEmail(email);

        if (user != null) {
            return ResponseEntity.ok(user.get().getUsername());
        } else {
            // Если пользователь не найден, возвращаем ошибку 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}

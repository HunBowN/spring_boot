package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно зарегестрирован");
        } catch(UserAlreadyExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
   public ResponseEntity getUsers() {
       try {
            return ResponseEntity.ok("Сервер работает");
       } catch(Exception ex) {
           return ResponseEntity.badRequest().body("Произошла ошибка");
       }
   }
}

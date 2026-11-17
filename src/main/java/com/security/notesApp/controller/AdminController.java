package com.security.notesApp.controller;

import com.security.notesApp.dtos.UserDTO;
import com.security.notesApp.models.User;
import com.security.notesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PutMapping("/update-role")
    public ResponseEntity<String> updateUserRole(
            @RequestParam Long userId,
            @RequestParam String roleName) {

        userService.updateUserRole(userId, roleName);

        return ResponseEntity.ok("User role updated");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                userService.getUserById(id),
                HttpStatus.OK
        );
    }
}

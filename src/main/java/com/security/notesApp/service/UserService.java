package com.security.notesApp.service;

import com.security.notesApp.dtos.UserDTO;
import com.security.notesApp.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void updateUserRole(Long userId, String roleName);

    UserDTO getUserById(Long id);
}

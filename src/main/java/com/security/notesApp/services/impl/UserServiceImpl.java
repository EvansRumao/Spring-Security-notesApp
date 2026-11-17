package com.security.notesApp.services.impl;

import com.security.notesApp.dtos.UserDTO;
import com.security.notesApp.models.AppRole;
import com.security.notesApp.models.Role;
import com.security.notesApp.models.User;
import com.security.notesApp.repositories.RoleRepository;
import com.security.notesApp.repositories.UserRepository;
import com.security.notesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        AppRole appRole = AppRole.valueOf(roleName);


        Role role = roleRepository.findByRoleName(appRole)
                .orElseThrow(
                        () -> new RuntimeException("Role not found")
                );

        user.setRole(role);

        userRepository.save(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Username not exit"));
        return convertToDto(user);
    }

    private UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.isAccountNonLocked(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCredentialsExpiryDate(),
                user.getAccountExpiryDate(),
                user.isTwoFactorEnabled(),
                user.getSignUpMethod(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }
}

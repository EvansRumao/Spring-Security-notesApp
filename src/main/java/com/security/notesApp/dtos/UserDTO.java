package com.security.notesApp.dtos;

import com.security.notesApp.models.AppRole;
import com.security.notesApp.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserDTO {
    private Long userId;

    private String userName;

    private String email;

    private boolean accountNonLocked;

    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private LocalDate credentialsExpiryDate;

    private LocalDate accountExpiryDate;

    private boolean twoFactorEnabled;

    private String signUpMethod;

    private Role role;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}

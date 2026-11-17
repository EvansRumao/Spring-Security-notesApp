package com.security.notesApp.repositories;

import com.security.notesApp.models.AppRole;
import com.security.notesApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}

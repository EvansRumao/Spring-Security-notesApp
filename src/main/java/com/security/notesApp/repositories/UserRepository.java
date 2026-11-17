package com.security.notesApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.notesApp.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
 Optional<User> findByUserName(String name);


    boolean existsByUserName(String username);
}

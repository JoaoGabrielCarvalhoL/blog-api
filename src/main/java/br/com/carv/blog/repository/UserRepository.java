package br.com.carv.blog.repository;

import br.com.carv.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    User findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}

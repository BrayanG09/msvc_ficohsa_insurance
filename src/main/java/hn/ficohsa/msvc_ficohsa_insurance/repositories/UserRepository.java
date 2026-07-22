package hn.ficohsa.msvc_ficohsa_insurance.repositories;

import hn.ficohsa.msvc_ficohsa_insurance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
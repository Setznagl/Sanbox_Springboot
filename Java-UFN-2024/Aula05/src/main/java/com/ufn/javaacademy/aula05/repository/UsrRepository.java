package com.ufn.javaacademy.aula05.repository;

import com.ufn.javaacademy.aula05.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsrRepository extends JpaRepository<Usr, Long> {
    Optional<Usr> findByUsername(String username);
}

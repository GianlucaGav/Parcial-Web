package com.example.backend.repository;

import com.example.backend.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadorRepository extends JpaRepository<Jugador, Long> {
}

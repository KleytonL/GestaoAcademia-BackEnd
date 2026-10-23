package com.academia.api.repository;

import com.academia.api.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findByUsuarioId(Long usuarioId);
}
package com.example.InfoCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.InfoCheck.entities.Banco;

public interface BancoRepository extends JpaRepository<Banco, Integer> {
}

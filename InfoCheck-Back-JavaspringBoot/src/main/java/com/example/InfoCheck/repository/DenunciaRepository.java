package com.example.InfoCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.InfoCheck.entities.Denuncia;
import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

    @Query("SELECT d FROM Denuncia d WHERE d.banco.id_banco = :idBanco")
    List<Denuncia> findByBancoId(@Param("idBanco") Integer idBanco);

    @Query("SELECT d FROM Denuncia d WHERE d.usuario.cpf = :cpf")
    List<Denuncia> findByUsuarioCpf(@Param("cpf") String cpf);
}

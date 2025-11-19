package com.example.InfoCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.InfoCheck.entities.Banco;
import com.example.InfoCheck.repository.BancoRepository;
import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository repo;

    public List<Banco> listarTodos(){
        return repo.findAll();
    }

    public Banco salvar(Banco banco){
        return repo.save(banco);
    }

    public Banco buscarPorId(Integer id){
        return repo.findById(id).orElse(null);
    }
}

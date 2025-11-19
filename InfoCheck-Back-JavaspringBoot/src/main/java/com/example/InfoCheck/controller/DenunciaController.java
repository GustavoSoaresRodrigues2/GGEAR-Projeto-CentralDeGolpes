package com.example.InfoCheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.InfoCheck.entities.Denuncia;
import com.example.InfoCheck.dtos.DenunciaDTO;
import com.example.InfoCheck.service.DenunciaService;
import java.util.List;

@RestController
@RequestMapping("/api/denuncias")
@CrossOrigin
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @PostMapping
    public Denuncia criar(@RequestBody DenunciaDTO dto){
        return service.criar(dto);
    }

    @GetMapping
    public List<Denuncia> listarTodas(){
        return service.listarTodas();
    }

    @GetMapping("/banco/{idBanco}")
    public List<Denuncia> listarPorBanco(@PathVariable Integer idBanco){
        return service.listarPorBanco(idBanco);
    }

    @GetMapping("/usuario/{cpf}")
    public List<Denuncia> listarPorCpf(@PathVariable String cpf){
        return service.listarPorCpf(cpf);
    }
}

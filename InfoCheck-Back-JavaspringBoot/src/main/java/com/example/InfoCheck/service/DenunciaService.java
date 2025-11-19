package com.example.InfoCheck.service;

import com.example.InfoCheck.dtos.DenunciaDTO;
import com.example.InfoCheck.entities.Banco;
import com.example.InfoCheck.entities.Denuncia;
import com.example.InfoCheck.entities.TipoGolpe;
import com.example.InfoCheck.entities.Usuario;
import com.example.InfoCheck.repository.BancoRepository;
import com.example.InfoCheck.repository.DenunciaRepository;
import com.example.InfoCheck.repository.TipoGolpeRepository;
import com.example.InfoCheck.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private BancoRepository bancoRepo;

    @Autowired
    private TipoGolpeRepository tipoGolpeRepo;

    // 🔹 Esse é o método que o controller está chamando: service.criar(dto)
    public Denuncia criar(DenunciaDTO dto) {
        Usuario usuario = usuarioRepo.findById(dto.getIdUsuario()).orElse(null);
        Banco banco = bancoRepo.findById(dto.getIdBanco()).orElse(null);
        TipoGolpe tipo = tipoGolpeRepo.findById(dto.getIdTipoGolpe()).orElse(null);

        Denuncia denuncia = new Denuncia();
        denuncia.setUsuario(usuario);
        denuncia.setBanco(banco);
        denuncia.setTipoGolpe(tipo); // vamos garantir esse setter na entidade
        denuncia.setContatoDenunciado(dto.getContatoDenunciado());
        denuncia.setDescricao(dto.getDescricao());

        return denunciaRepo.save(denuncia);
    }

    public List<Denuncia> listarTodas() {
        return denunciaRepo.findAll();
    }

    public List<Denuncia> listarPorBanco(Integer idBanco) {
        return denunciaRepo.findByBancoId(idBanco);
    }

    // 🔹 Esse é o método que o controller está chamando: service.listarPorCpf(cpf)
    public List<Denuncia> listarPorCpf(String cpf) {
        return denunciaRepo.findByUsuarioCpf(cpf);
    }
}

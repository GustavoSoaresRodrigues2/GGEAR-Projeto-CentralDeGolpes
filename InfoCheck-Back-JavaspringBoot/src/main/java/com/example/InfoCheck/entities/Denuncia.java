package com.example.InfoCheck.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_denuncia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoGolpe tipoGolpe;

    @Column(name = "contato_denunciado", nullable = false, length = 150)
    private String contatoDenunciado;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_denuncia")
    private LocalDateTime data_denuncia = LocalDateTime.now();

    // getters e setters principais

    public Integer getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(Integer id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public TipoGolpe getTipoGolpe() {
        return tipoGolpe;
    }

    public void setTipoGolpe(TipoGolpe tipoGolpe) {
        this.tipoGolpe = tipoGolpe;
    }

    public String getContatoDenunciado() {
        return contatoDenunciado;
    }

    public void setContatoDenunciado(String contatoDenunciado) {
        this.contatoDenunciado = contatoDenunciado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData_denuncia() {
        return data_denuncia;
    }

    public void setData_denuncia(LocalDateTime data_denuncia) {
        this.data_denuncia = data_denuncia;
    }
}

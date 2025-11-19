package com.example.InfoCheck.dtos;

public class DenunciaDTO {

    private Integer idUsuario;        // id do usuário que está denunciando
    private Integer idBanco;          // id do banco envolvido
    private Integer idTipoGolpe;      // id do tipo de golpe
    private String contatoDenunciado; // telefone/email/site denunciado
    private String descricao;         // descrição do golpe

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Integer getIdTipoGolpe() {
        return idTipoGolpe;
    }

    public void setIdTipoGolpe(Integer idTipoGolpe) {
        this.idTipoGolpe = idTipoGolpe;
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
}

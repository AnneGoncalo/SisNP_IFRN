/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.dominio;

import java.util.Calendar;

/**
 *
 * @author anne
 */
public class Atividade {
    private int id;
    private String descricao;
    private Calendar inicio;
    private int duracaoEstimada;
    private int estado;
    private Usuario autor;
    private Usuario responsavel;

    public Atividade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public int getDuracaoEstimada() {
        return duracaoEstimada;
    }

    public void setDuracaoEstimada(int duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
    
    
}

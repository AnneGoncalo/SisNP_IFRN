/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.dominio;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author anne
 */
public class Meta {
    private int id;
    private String titulo;
    private Date dataAlvo;
    private double andamento;
    private List<Atividade> atividades;

    public Meta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataAlvo() {
        return dataAlvo;
    }

    public void setDataAlvo(Date dataAlvo) {
        this.dataAlvo = dataAlvo;
    }

    public double getAndamento() {
        return andamento;
    }

    public void setAndamento(double andamento) {
        this.andamento = andamento;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.dominio;

/**
 *
 * @author anne
 */
public enum EstadoAtividade {
    ATRIBUIDA(0), 
    EMANDAMENTO(1),
    CONCLUIDA(2),
    FECHADA(3);
    
    private int valorEstado;

    EstadoAtividade(int valorEstado){
        this.valorEstado = valorEstado;
    }
    
    public static EstadoAtividade getATRIBUIDA() {
        return ATRIBUIDA;
    }

    public static EstadoAtividade getEMANDAMENTO() {
        return EMANDAMENTO;
    }

    public static EstadoAtividade getCONCLUIDA() {
        return CONCLUIDA;
    }

    public static EstadoAtividade getFECHADA() {
        return FECHADA;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.persistencia;

import java.sql.SQLException;

/**
 *
 * @author jeanjar
 */
public class Mediator {
    private DAProjeto daProjeto = null;
    private DAUsuario daUsuario = null;
    private DANoticia daNoticia = null;
    private DAMeta daMeta = null;
    private DAAtividade daAtividade = null;
    
    public static Mediator instance = null;
    
    private Mediator(){}
    
    public Mediator getInstance()
    {
        if(instance == null)
        {
            instance = new Mediator();
        }
        return instance;
    }

    public DAProjeto getDaProjeto()throws SQLException{
        if(this.daProjeto == null)
        {
            this.daProjeto = new DAProjeto();
        }
        return daProjeto;
    }

    public DAUsuario getDaUsuario() throws SQLException{
        if(this.daUsuario == null)
        {
            this.daUsuario = new DAUsuario();
        }
        return daUsuario;
    }

    public DANoticia getDaNoticia() throws SQLException{
        if(this.daNoticia == null)
        {
            this.daNoticia = new DANoticia();
        }
        return daNoticia;
    }

    public DAMeta getDaMeta() throws SQLException{
        if(this.daMeta == null)
        {
            this.daMeta = new DAMeta();
        }
        return daMeta;
    }

    public DAAtividade getDaAtividade() throws SQLException{
        if(this.daAtividade == null)
        {
            this.daAtividade = new DAAtividade();
        }
        return daAtividade;
    }
}

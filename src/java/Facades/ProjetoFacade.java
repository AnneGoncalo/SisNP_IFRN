/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import java.sql.SQLException;
import sisnp.ifrn.br.dominio.Meta;
import sisnp.ifrn.br.persistencia.DAAtividade;
import sisnp.ifrn.br.persistencia.DAMeta;
import sisnp.ifrn.br.persistencia.DANoticia;
import sisnp.ifrn.br.persistencia.DAProjeto;
import sisnp.ifrn.br.persistencia.DAUsuario;
import sisnp.ifrn.br.dominio.Projeto;

/**
 *
 * @author jeanjar
 */
public class ProjetoFacade {
    
    private DAProjeto dataAccess = null;
    private DAUsuario dataAccessUsuario = null;
    private DANoticia daNoticia = null;
    private DAMeta daMeta = null;
    private DAAtividade daAtividade = null;
        
    public ProjetoFacade() throws SQLException{
        dataAccess = new DAProjeto();
        dataAccessUsuario = new DAUsuario();
        daNoticia = new DANoticia();
        daMeta = new DAMeta();
        daAtividade = new DAAtividade();
    }
    
    public Projeto run(int idProjeto)
    {
        Projeto projeto = dataAccess.getProjeto(idProjeto);
        projeto.setEquipe(dataAccessUsuario.getEquipe(idProjeto));
        projeto.setNoticias(daNoticia.getNoticias(idProjeto));
        projeto.setMetas(daMeta.getMetas(idProjeto));
        for(Meta m: projeto.getMetas())
        {
            m.setAtividades(daAtividade.getAtividades(m.getId()));
        }
        return projeto;
    }
    
    
}

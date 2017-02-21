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
import sisnp.ifrn.br.persistencia.Mediator;

/**
 *
 * @author jeanjar
 */
public class ProjetoFacade {
   
    public ProjetoFacade(){}
    
    public Projeto run(int idProjeto) throws SQLException
    {
        Projeto projeto = Mediator.getInstance().getDaProjeto().getProjeto(idProjeto);
        projeto.setEquipe(Mediator.getInstance().getDaUsuario().getEquipe(idProjeto));
        projeto.setNoticias(Mediator.getInstance().getDaNoticia().getNoticias(idProjeto));
        projeto.setMetas(Mediator.getInstance().getDaMeta().getMetas(idProjeto));
        for(Meta m: projeto.getMetas())
        {
            m.setAtividades(Mediator.getInstance().getDaAtividade().getAtividades(m.getId()));
        }
        return projeto;
    }
}

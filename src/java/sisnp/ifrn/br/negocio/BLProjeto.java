package sisnp.ifrn.br.negocio;

import java.sql.SQLException;
import sisnp.ifrn.br.dominio.Meta;
import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DAAtividade;
import sisnp.ifrn.br.persistencia.DAMeta;
import sisnp.ifrn.br.persistencia.DANoticia;
import sisnp.ifrn.br.persistencia.DAProjeto;
import sisnp.ifrn.br.persistencia.DAUsuario;

public class BLProjeto {
    private DAProjeto dataAccess = null;
    private DAUsuario dataAccessUsuario = null;
    private DANoticia daNoticia = null;
    private DAMeta daMeta = null;
    private DAAtividade daAtividade = null;
    
    public BLProjeto() throws SQLException {
        super();
        dataAccess = new DAProjeto();
        dataAccessUsuario = new DAUsuario();
        daNoticia = new DANoticia();
        daMeta = new DAMeta();
        daAtividade = new DAAtividade();
    }
    
    public Projeto getProjeto(int idProjeto) {
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

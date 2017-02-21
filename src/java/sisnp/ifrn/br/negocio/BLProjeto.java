package sisnp.ifrn.br.negocio;

import Facades.ProjetoFacade;
import java.sql.SQLException;
import sisnp.ifrn.br.dominio.Meta;
import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DAAtividade;
import sisnp.ifrn.br.persistencia.DAMeta;
import sisnp.ifrn.br.persistencia.DANoticia;
import sisnp.ifrn.br.persistencia.DAProjeto;
import sisnp.ifrn.br.persistencia.DAUsuario;

public class BLProjeto {
    ProjetoFacade projetoFacade = new ProjetoFacade();
    
    public BLProjeto() throws SQLException {
        super();
    }
    
    public Projeto getProjeto(int idProjeto) throws SQLException { 
        return this.projetoFacade.run(idProjeto);
    }
}

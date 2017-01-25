package sisnp.ifrn.br.negocio;

import java.sql.SQLException;
import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DAProjeto;
import sisnp.ifrn.br.persistencia.DAUsuario;

public class BLProjeto {
    private DAProjeto dataAccess = null;
    private DAUsuario dataAccessUsuario = null;
    
    public BLProjeto() throws SQLException {
        super();
        dataAccess = new DAProjeto();
        dataAccessUsuario = new DAUsuario();
    }
    
    public Projeto getProjeto(int idProjeto) {
        Projeto projeto = dataAccess.getProjeto(idProjeto);
        projeto.setEquipe(dataAccessUsuario.getEquipe(idProjeto));
        return projeto;
    }
}

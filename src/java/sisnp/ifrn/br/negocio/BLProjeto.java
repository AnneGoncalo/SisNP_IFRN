package sisnp.ifrn.br.negocio;

import Facades.ProjetoFacade;
import java.sql.SQLException;
import sisnp.ifrn.br.dominio.Projeto;

public class BLProjeto {
    ProjetoFacade projetoFacade = new ProjetoFacade();
    
    public BLProjeto() throws SQLException {
        super();
    }
    
    public Projeto getProjeto(int idProjeto) throws SQLException { 
        return this.projetoFacade.get(idProjeto);
    }
    
    public void addProjeto(Projeto projeto) throws SQLException{
        //Possiveis verificações
        
        projeto.setConcluido(false);
        projetoFacade.add(projeto);
    }
}

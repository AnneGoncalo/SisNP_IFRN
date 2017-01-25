/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Atividade;

/**
 *
 * @author anne
 */
public class DAAtividade {
    
    private Connection conn;
    
    public DAAtividade() throws SQLException{
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }
    
    public List<Atividade> getAtividades(int idMeta) {
        if (conn != null) {
            try {
                List<Atividade> atividades = new ArrayList();
                PreparedStatement psGetAtividades = conn.prepareStatement("SELECT * FROM atividade WHERE id_meta = ?");
                psGetAtividades.setInt(1, idMeta);
                ResultSet rsGetAtividades = psGetAtividades.executeQuery();
                while (rsGetAtividades.next()) {
                    Atividade atividade = new Atividade();
                    atividade.setId(rsGetAtividades.getInt("id"));
                    atividade.setDescricao(rsGetAtividades.getString("descricao"));
                    atividade.setDuracaoEstimada(rsGetAtividades.getInt("duracao_estimada"));
                    atividade.setEstado(rsGetAtividades.getInt("estado"));
                    atividades.add(atividade);
                }
                psGetAtividades.close();
                return atividades;
            } catch (SQLException ex) {
                Logger.getLogger(DAAtividade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

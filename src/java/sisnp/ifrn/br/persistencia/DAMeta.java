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
import sisnp.ifrn.br.dominio.Meta;

/**
 *
 * @author anne
 */
public class DAMeta {
    
    private Connection conn;
    
    public DAMeta() throws SQLException{
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }
    
    public List<Meta> getMetas(int idProjeto) {
        if (conn != null) {
            try {
                List<Meta> metas = new ArrayList();
                PreparedStatement psGetMetas = conn.prepareStatement("SELECT * FROM meta WHERE id_projeto = ?");
                psGetMetas.setInt(1, idProjeto);
                ResultSet rsGetMetas = psGetMetas.executeQuery();
                while (rsGetMetas.next()) {
                    Meta meta = new Meta();
                    meta.setId(rsGetMetas.getInt("id"));
                    meta.setTitulo(rsGetMetas.getString("titulo"));
                    meta.setAndamento(rsGetMetas.getDouble("andamento"));
                    meta.setDataAlvo(rsGetMetas.getDate("data_alvo"));
                    metas.add(meta);
                }
                psGetMetas.close();
                return metas;
            } catch (SQLException ex) {
                Logger.getLogger(DAMeta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

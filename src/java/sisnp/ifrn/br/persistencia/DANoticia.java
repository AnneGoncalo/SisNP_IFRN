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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Noticia;

/**
 *
 * @author anne
 */
public class DANoticia {

    private Connection conn;

    public DANoticia() throws SQLException {
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }

    public List<Noticia> getNoticias(int idProjeto) {
        if (conn != null) {
            try {
                List<Noticia> noticias = new ArrayList();
                PreparedStatement psGetNoticias = conn.prepareStatement("SELECT * FROM noticia WHERE id_projeto = ?");
                psGetNoticias.setInt(1, idProjeto);
                ResultSet rsGetNoticias = psGetNoticias.executeQuery();
                while (rsGetNoticias.next()) {
                    Noticia noticia = new Noticia();
                    noticia.setId(rsGetNoticias.getInt("id"));
                    noticia.setTitulo(rsGetNoticias.getString("titulo"));
                    noticia.setTexto(rsGetNoticias.getString("texto"));
                    noticia.setData(rsGetNoticias.getDate("dataPublicacao"));
                    noticias.add(noticia);
                }
                psGetNoticias.close();
                return noticias;
            } catch (SQLException ex) {
                Logger.getLogger(DANoticia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

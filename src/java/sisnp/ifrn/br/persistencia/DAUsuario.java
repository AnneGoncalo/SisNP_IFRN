/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Usuario;

/**
 *
 * @author anne
 */
public class DAUsuario {

    private Connection conn;
    

    public DAUsuario() throws SQLException {
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }

    public List<Usuario> getEquipe(int idProjeto) {
        if (conn != null) {
            try {
                List<Usuario> usuarios = new ArrayList();
                
                PreparedStatement psGetDocentes = conn.prepareStatement("select * from usuario "
                        + "inner join docente on docente.id = usuario.id "
                        + "inner join docente_projeto on docente_projeto.id_docente = docente.id "
                        + "where docente_projeto.id_projeto = ? ;");
                psGetDocentes.setInt(1, idProjeto);
                ResultSet rsGetUsuarios = psGetDocentes.executeQuery();
                while (rsGetUsuarios.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rsGetUsuarios.getInt("usuario.id"));
                    usuario.setLogin(rsGetUsuarios.getString("usuario.login"));
                    usuario.setNome(rsGetUsuarios.getString("usuario.nome"));
                    usuario.setSenha(rsGetUsuarios.getString("usuario.senha"));
                    usuario.setAtivo(rsGetUsuarios.getBoolean("usuario.ativo"));
                    usuarios.add(usuario);
                }
                psGetDocentes.close();

                PreparedStatement psGetDiscentes = conn.prepareStatement("select * from usuario "
                        + "inner join discente on discente.id = usuario.id "
                        + "inner join discente_projeto on discente_projeto.id_discente = discente.id "
                        + "where discente_projeto.id_projeto = ? ;");
                psGetDiscentes.setInt(1, idProjeto);
                rsGetUsuarios = psGetDiscentes.executeQuery();
                while (rsGetUsuarios.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rsGetUsuarios.getInt("usuario.id"));
                    usuario.setLogin(rsGetUsuarios.getString("usuario.login"));
                    usuario.setNome(rsGetUsuarios.getString("usuario.nome"));
                    usuario.setSenha(rsGetUsuarios.getString("usuario.senha"));
                    usuario.setAtivo(rsGetUsuarios.getBoolean("usuario.ativo"));
                    usuarios.add(usuario);
                }
                psGetDiscentes.close();
                
                return usuarios;
            } catch (SQLException ex) {
                Logger.getLogger(DAUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public Usuario getAutorNoticia(int idNoticia) {
        if (conn != null) {
            try {
                PreparedStatement psGetAutor = conn.prepareStatement
                                  ("SELECT * FROM noticia " +
                        "inner join usuario on noticia.id_usuario = usuario.id "+
                        "WHERE noticia.id = ?");
                psGetAutor.setInt(1, idNoticia);
                ResultSet rsGetAutor = psGetAutor.executeQuery();
                Usuario autor = new Usuario();
                if (rsGetAutor.next()) {
                    autor.setId(rsGetAutor.getInt("usuario.id"));
                    autor.setNome(rsGetAutor.getString("usuario.nome"));
                    psGetAutor.close();
                    return autor;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    

}

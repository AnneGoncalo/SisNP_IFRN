/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anne
 */
public class FabricaConexao {

    private static FabricaConexao instancia1;
    private static FabricaConexao instancia2;
    private static int ultima = 2;

    private Connection conn;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnp";
    private final String USER = "root";
    private final String PASS = "ananne";

    private FabricaConexao() throws SQLException {
        super();
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(BANCO, USER, PASS);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static FabricaConexao getInstancia() throws SQLException {
        FabricaConexao fab = null;
        if (ultima == 2) {
            if (instancia1 == null) {
                instancia1 = new FabricaConexao();
            }
            ultima = 1;
            fab = instancia1;
        } else {
            if (instancia2 == null) {
                instancia2 = new FabricaConexao();
            }
            ultima = 2;
            fab = instancia2;
        }
        
        return fab;
    }

    public Connection getConexao() {
        return conn;
    }
}

package sisnp.ifrn.br.apresentacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.negocio.BLProjeto;

public class InfoProjeto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String idProjeto = request.getParameter("idProjeto");
        if (idProjeto!=null && !idProjeto.isEmpty()) {
            BLProjeto bl = new BLProjeto();
            int id = Integer.parseInt(idProjeto);
            Projeto projeto = bl.getProjeto(id);
            request.setAttribute("projeto", projeto);
            request.getRequestDispatcher("/viewProjeto.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/viewErro.jsp?msg=\"parInvalidos\"").forward(request, response);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InfoProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InfoProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

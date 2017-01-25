package sisnp.ifrn.br.apresentacao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.negocio.BLProjeto;

public class InfoProjeto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProjeto = request.getParameter("idProjeto");
        if (idProjeto!=null && !idProjeto.isEmpty()) {
            BLProjeto bl = new BLProjeto();
            int id = Integer.parseInt(idProjeto);
            Projeto projeto = bl.getProjeto(id);
            HttpSession session = request.getSession();
            session.setAttribute("projeto", projeto);
            request.getRequestDispatcher("/viewProjeto.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/viewErro.jsp?msg=\"parInvalidos\"").forward(request, response);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

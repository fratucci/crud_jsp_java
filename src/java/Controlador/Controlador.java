package Controlador;

import Modelo.Pessoa;
import ModeloDAO.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    Pessoa a = new Pessoa();
    PessoaDAO dao = new PessoaDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String acesso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acesso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acesso = add;
        } else if (action.equalsIgnoreCase("Adicionar")) {
            String nome = request.getParameter("txtNome");
            String endereco = request.getParameter("txtEndereco");
            String cidade = request.getParameter("txtCidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("txtEmail");
            a.setNome(nome);
            a.setEndereco(endereco);
            a.setCidade(cidade);
            a.setEstado(estado);
            a.setEmail(email);
            dao.add(a);
            acesso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            a.setId(id);
            dao.eliminar(id);
            acesso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id-a", request.getParameter("id"));
            acesso = edit;
        } else if (action.equalsIgnoreCase("Atualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nome = request.getParameter("txtNome");
            String endereco = request.getParameter("txtEndereco");
            String cidade = request.getParameter("txtCidade");
            String estado = request.getParameter("txtEstado");
            String email = request.getParameter("txtEmail");
            a.setId(id);
            a.setNome(nome);
            a.setEndereco(endereco);
            a.setCidade(cidade);
            a.setEstado(estado);
            a.setEmail(email);
            dao.edit(a);
            acesso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acesso);
        vista.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import model.Vendedor;
import dao.VendedorDAO;

@WebServlet("/CadastroVendedorServlet")
public class CadastroVendedorServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("vendedorId"));
	        String nome = request.getParameter("nome");
	        String cidade = request.getParameter("cidade");
	        double comissao = Double.parseDouble(request.getParameter("comissao"));

	        Vendedor vendedor = new Vendedor();
	        vendedor.setVendedorId(id);
	        vendedor.setNome(nome);
	        vendedor.setCidade(cidade);
	        vendedor.setComissao(comissao);

	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?useSSL=false&useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "*Bd25@MySQL!");
	            VendedorDAO dao = new VendedorDAO(con);
	            dao.salvar(vendedor);
	            con.close();
	        } catch (Exception e) {
	            throw new ServletException(e);
	        }

	        response.sendRedirect("listar.jsp");
	    }
}

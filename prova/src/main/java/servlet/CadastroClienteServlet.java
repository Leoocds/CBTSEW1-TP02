package servlet;

import model.Cliente;
import dao.ClienteDAO;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/CadastroClienteServlet")
public class CadastroClienteServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {

		        int id = Integer.parseInt(request.getParameter("clientesId"));
		        String nome = request.getParameter("clienteNome");
		        String cidade = request.getParameter("cidade");
		        int categoria = Integer.parseInt(request.getParameter("categoria"));
		        int vendedorId = Integer.parseInt(request.getParameter("vendedorId"));

		        Cliente cliente = new Cliente();
		        cliente.setClienteId(id);
		        cliente.setClienteNome(nome);
		        cliente.setCidade(cidade);
		        cliente.setCategoria(categoria);
		        cliente.setVendedorId(vendedorId);

		        try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?useSSL=false&useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "*Bd25@MySQL!");
		            ClienteDAO dao = new ClienteDAO(con);
		            dao.salvar(cliente);
		            con.close();
		        } catch (Exception e) {
		            throw new ServletException(e);
		        }

		        response.sendRedirect("listar.jsp");
		    }
}

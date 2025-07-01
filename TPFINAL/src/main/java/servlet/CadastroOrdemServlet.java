package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import model.Ordem;
import dao.OrdemDAO;

@WebServlet("/CadastroOrdemServlet")
public class CadastroOrdemServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {

		        int ordemId = Integer.parseInt(request.getParameter("ordemId"));
		        double valorCompra = Double.parseDouble(request.getParameter("valorCompra"));
		        Date data = Date.valueOf(request.getParameter("data")); // formato: YYYY-MM-DD
		        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		        int vendedorId = Integer.parseInt(request.getParameter("vendedorId"));

		        Ordem ordem = new Ordem();
		        ordem.setOrdemId(ordemId);
		        ordem.setValorCompra(valorCompra);
		        ordem.setData(data);
		        ordem.setClienteId(clienteId);
		        ordem.setVendedorId(vendedorId);

		        try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?useSSL=false&useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "*Bd25@MySQL!");
		            OrdemDAO dao = new OrdemDAO(con);
		            dao.salvar(ordem);
		            con.close();
		        } catch (Exception e) {
		            throw new ServletException(e);
		        }

		        response.sendRedirect("listar.jsp");
		    }
}

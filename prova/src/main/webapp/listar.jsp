<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Listar</title>
 <style>
        table {border-collapse: collapse; width: 80%; margin-bottom: 30px;}
        th, td {border: 1px solid #ccc; padding: 8px; text-align: left;}
        th {background-color: #f2f2f2;}
    </style>
</head>
<body>
    <li><a href="${pageContext.request.contextPath}/cadastroCliente.jsp">Cadastrar Cliente</a></li>
    <li><a href="${pageContext.request.contextPath}/cadastroVendedor.jsp">Cadastrar Vendedor</a></li>
    <li><a href="${pageContext.request.contextPath}/cadastroOrdem.jsp">Cadastrar Ordem</a></li> 
    
<h2>Vendedores</h2>
<table>
    <tr>
        <th>ID</th><th>Nome</th><th>Cidade</th><th>Comissão</th>
    </tr>
    <%
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=America/Sao_Paulo", "root", "*Bd25@MySQL!");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT vendedor_id, nome, cidade, comissao FROM vendedor");
            while(rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("vendedor_id") %></td>
        <td><%= rs.getString("nome") %></td>
        <td><%= rs.getString("cidade") %></td>
        <td><%= rs.getDouble("comissao") %></td>
    </tr>
    <%
            }
            rs.close();
    %>
</table>

<h2>Clientes</h2>
<table>
    <tr>
        <th>ID</th><th>Nome</th><th>Cidade</th><th>Classificação</th><th>Vendedor ID</th>
    </tr>
    <%
            rs = stmt.executeQuery("SELECT clientes_id, cliente_nome, cidade, categoria, vendedor_id FROM clientes");
            while(rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("clientes_id") %></td>
        <td><%= rs.getString("cliente_nome") %></td>
        <td><%= rs.getString("cidade") %></td>
        <td><%= rs.getString("categoria") %></td>
        <td><%= rs.getInt("vendedor_id") %></td>
    </tr>
    <%
            }
            rs.close();
    %>
</table>

<h2>Ordens</h2>
<table>
    <tr>
        <th>ID</th><th>Valor Compra</th><th>Data</th><th>Cliente ID</th><th>Vendedor ID</th>
    </tr>
    <%
            rs = stmt.executeQuery("SELECT ord_n, valor, ord_data, clientes_id, vendedor_id FROM ordens");
            while(rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("ord_n") %></td>
        <td><%= rs.getDouble("valor") %></td>
        <td><%= rs.getDate("ord_data") %></td>
        <td><%= rs.getInt("clientes_id") %></td>
        <td><%= rs.getInt("vendedor_id") %></td>
    </tr>
    <%
            }
        } catch(Exception e) {
            out.println("<p>Erro: " + e.getMessage() + "</p>");
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e) {}
            try { if(stmt != null) stmt.close(); } catch(Exception e) {}
            try { if(con != null) con.close(); } catch(Exception e) {}
        }
    %>
</table>
</body>
</html>
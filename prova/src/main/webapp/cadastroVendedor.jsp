<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Vendedor</title>
</head>
<body>
<h2>Cadastro de Vendedor</h2>
<form action="${pageContext.request.contextPath}/CadastroVendedorServlet" method="post">
    <label>ID Vendedor:</label><br>
    <input type="number" name="vendedorId" required><br><br>

    <label>Nome:</label><br>
    <input type="text" name="nome" required><br><br>

    <label>Cidade:</label><br>
    <input type="text" name="cidade" required><br><br>

    <label>Comissão:</label><br>
    <input type="number" step="0.01" name="comissao" required><br><br>

    <button type="submit">Cadastrar</button>
</form>

<p><a href="listar.jsp">Voltar à listagem</a></p>
</body>
</html>
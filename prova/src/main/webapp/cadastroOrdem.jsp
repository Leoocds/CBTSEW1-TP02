<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastrar Ordem</title>
</head>
<body>
<h2>Cadastro de Ordem</h2>
<form action="${pageContext.request.contextPath}/CadastroOrdemServlet" method="post">
    <label>ID da Ordem:</label><br>
    <input type="number" name="ordemId" required><br><br>

    <label>Valor da Compra:</label><br>
    <input type="number" step="0.01" name="valorCompra" required><br><br>

    <label>Data (AAAA-MM-DD):</label><br>
    <input type="date" name="data" required><br><br>

    <label>ID do Cliente:</label><br>
    <input type="number" name="clienteId" required><br><br>

    <label>ID do Vendedor:</label><br>
    <input type="number" name="vendedorId" required><br><br>

    <button type="submit">Cadastrar</button>
</form>

<p><a href="listar.jsp">Voltar à listagem</a></p>
</body>
</html>
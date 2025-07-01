<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head><title>Cadastrar Cliente</title></head>
<body>
<h2>Cadastro de Cliente</h2>
<form action="${pageContext.request.contextPath}/CadastroClienteServlet" method="post">
    <label>ID Cliente:</label><br>
    <input type="number" name="clientesId" required><br><br>

    <label>Nome:</label><br>
    <input type="text" name="clienteNome" required><br><br>

    <label>Cidade:</label><br>
    <input type="text" name="cidade" required><br><br>

    <label>Classificação (Grade):</label><br>
    <input type="text" name="categoria" required><br><br>

    <label>ID do Vendedor:</label><br>
    <input type="number" name="vendedorId" required><br><br>

    <button type="submit">Cadastrar</button>
</form>

<p><a href="listar.jsp">Voltar à listagem</a></p>
</body>
</html>

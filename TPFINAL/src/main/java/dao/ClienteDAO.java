package dao;
import java.sql.*;
import model.Cliente;

public class ClienteDAO {

    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (clientes_id, cliente_nome, cidade, categoria, vendedor_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, cliente.getClienteId());
        stmt.setString(2, cliente.getClienteNome());
        stmt.setString(3, cliente.getCidade());
        stmt.setInt(4, cliente.getCategoria());
        stmt.setInt(5, cliente.getVendedorId());
        stmt.executeUpdate();
    }
}


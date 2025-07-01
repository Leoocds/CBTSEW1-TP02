package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Ordem;

public class OrdemDAO {
	private Connection con;

    public OrdemDAO(Connection con) {
        this.con = con;
    }

    public void salvar(Ordem ordem) throws SQLException {
        String sql = "INSERT INTO ordens (ord_n, valor, ord_data, clientes_id, vendedor_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ordem.getOrdemId());
        stmt.setDouble(2, ordem.getValorCompra());
        stmt.setDate(3, ordem.getData());
        stmt.setInt(4, ordem.getClienteId());
        stmt.setInt(5, ordem.getVendedorId());
        stmt.executeUpdate();
    }
}

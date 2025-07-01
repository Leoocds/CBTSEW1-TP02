package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Vendedor;

public class VendedorDAO {
	 private Connection con;

	    public VendedorDAO(Connection con) {
	        this.con = con;
	    }

	    public void salvar(Vendedor vendedor) throws SQLException {
	        String sql = "INSERT INTO vendedor (vendedor_id, nome, cidade, comissao) VALUES (?, ?, ?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, vendedor.getVendedorId());
	        stmt.setString(2, vendedor.getNome());
	        stmt.setString(3, vendedor.getCidade());
	        stmt.setDouble(4, vendedor.getComissao());
	        stmt.executeUpdate();
	    }
}

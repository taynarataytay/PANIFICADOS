import java.sql.*;
import java.util.List;

public class PedidoDAO {

    public void criarPedido(Pedido pedido) throws SQLException {
        String sqlPedido = "INSERT INTO Pedido (usuario_id, total, status) VALUES (?, ?, ?)";
        String sqlItem = "INSERT INTO ItemPedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                stmtPedido.setInt(1, pedido.getUsuario().getId());
                stmtPedido.setDouble(2, pedido.getTotal());
                stmtPedido.setString(3, pedido.getStatus());
                stmtPedido.executeUpdate();

                ResultSet rs = stmtPedido.getGeneratedKeys();
                if (rs.next()) {
                    int pedidoId = rs.getInt(1);

                    for (ItemPedido item : pedido.getItens()) {
                        try (PreparedStatement stmtItem = conn.prepareStatement(sqlItem)) {
                            stmtItem.setInt(1, pedidoId);
                            stmtItem.setInt(2, item.getProduto().getId());
                            stmtItem.setInt(3, item.getQuantidade());
                            stmtItem.setDouble(4, item.getPrecoUnitario());
                            stmtItem.executeUpdate();
                        }
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    // Métodos adicionais para listar pedidos por usuário, atualizar status, etc.
}

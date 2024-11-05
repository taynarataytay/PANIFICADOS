import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void inserirProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (nome, descricao, preco, imagem) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getImagem());
            stmt.executeUpdate();
        }
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = ConexaoBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }
        }
        return produtos;
    }

    // Métodos adicionais para atualizar e deletar produtos
}

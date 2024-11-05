import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto();
        produto.setNome("Pão");
        produto.setPreco(5.00);

        ProdutoRepository produtoRepository = mock(ProdutoRepository.class);
        ProdutoService produtoService = new ProdutoService(produtoRepository);

        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto result = produtoService.adicionarProduto(produto);

        assertEquals("Pão", result.getNome());
        assertEquals(5.00, result.getPreco());
    }
}

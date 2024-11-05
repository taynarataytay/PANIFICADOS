import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto();
        produto.setNome("Pão");
        produto.setPreco(5.00);

        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

        Produto result = produtoService.adicionarProduto(produto);

        assertEquals("Pão", result.getNome());
        assertEquals(5.00, result.getPreco());
    }
}

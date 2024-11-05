public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String imagem;

    import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Produto {
    
    @NotNull(message = "O ID não pode ser nulo")
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Positive(message = "O preço deve ser maior que zero")
    private Double preco;


}




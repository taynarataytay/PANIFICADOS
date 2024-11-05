import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Usuario usuario;
    private Date dataPedido;
    private double total;
    private String status;
    private List<ItemPedido> itens;

}

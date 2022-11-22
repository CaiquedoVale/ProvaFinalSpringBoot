package APIProduto.APIProduto.PedidoDTO;

public class PedidoDTO {

    private String parcelas;

    public PedidoDTO() {
    }

    public PedidoDTO(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }
}
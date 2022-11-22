package APIProduto.APIProduto.utils;

import APIProduto.APIProduto.entity.Itens;
import APIProduto.APIProduto.entity.Pedido;
import org.springframework.stereotype.Service;

@Service
public class Calculo
{
    public Pedido calcP(Pedido pedido)
    {
        if(pedido.getParcelas() >= 10)
        {
            Double valorTotalAcressimo = pedido.getValorTotal() + (pedido.getValorTotal() * 0.1);
            pedido.setValorTotal(valorTotalAcressimo);
            return pedido;
        }
        else
        {
            return pedido;
        }
    }
}

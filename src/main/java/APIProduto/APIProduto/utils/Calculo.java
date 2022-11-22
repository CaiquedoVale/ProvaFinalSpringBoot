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
            Double valorT = 0.0;
            for(Itens p : pedido.getItens()){
                valorT=valorT+p.getPrecoTotal();

            }
            pedido.setValorTotal(valorT);
        }
        else
        {
            return pedido;
        }
    }
}

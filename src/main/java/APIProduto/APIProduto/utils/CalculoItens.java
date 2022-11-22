package APIProduto.APIProduto.utils;

import APIProduto.APIProduto.entity.Itens;
import org.springframework.stereotype.Service;

@Service
public class CalculoItens
{
    public Itens calcI(Itens itens)
    {
            Double somaItens = itens.getQuantidade() * itens.getPrecoIndividual();
            itens.setPrecoTotal(somaItens);
            return itens;

    }

}

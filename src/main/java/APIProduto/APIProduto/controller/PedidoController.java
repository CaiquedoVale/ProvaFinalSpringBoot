package APIProduto.APIProduto.controller;

import APIProduto.APIProduto.PedidoDTO.PedidoDTO;
import APIProduto.APIProduto.entity.Pedido;
import APIProduto.APIProduto.repository.PedidoRepository;
import APIProduto.APIProduto.utils.Calculo;
import APIProduto.APIProduto.utils.CalculoItens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedido/v1/")
public class PedidoController
{
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private Calculo calcP;
    @Autowired
    private CalculoItens calcI;

    @PostMapping
    @ResponseBody
    public Pedido create(@RequestBody Pedido pedido)
    {
//        Cliente clienteSocializado = calcs.calc(cliente);
        Pedido pedidoSaved = pedidoRepository.save(pedido);
        return pedidoSaved;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<Pedido> getPedidoById(@PathVariable Long id){
        Optional<Pedido> pedidoReturned =pedidoRepository.findById(id);
        return pedidoReturned;
    }

    @GetMapping("/todos")
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    @DeleteMapping("{id}")
    public String deletePedidoById(@PathVariable Long id){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if(pedidoOptional.isPresent())
        {
            pedidoRepository.deleteById(id);
            return "O pedido de id " + id + "foi deletado com sucesso!";
        }
        else
        {
            return "Pedido não existe!!!";
        }
    }

    @PutMapping("update/{id}/")
    public String updateParcelaById(@PathVariable Long id, @RequestParam("parcela") Integer parcelas)
    {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if(pedidoOptional.isPresent())
        {
            Pedido c = pedidoOptional.get();
            c.setParcelas(parcelas);
            pedidoRepository.save(c);
            return "As parcelas do pedido de id " + id + " foi atualizada com sucesso!";
        }
        else
        {
            return "Pedido não existe!!!";
        }
    }

}
package APIProduto.APIProduto.controller;

import APIProduto.APIProduto.entity.Pedido;
import APIProduto.APIProduto.repository.PedidoRepository;
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

//    @Autowired
//    private Calculo calcs;

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

    @GetMapping
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

}
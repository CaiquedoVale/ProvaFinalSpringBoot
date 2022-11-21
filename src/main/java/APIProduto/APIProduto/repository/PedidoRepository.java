package APIProduto.APIProduto.repository;

import APIProduto.APIProduto.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

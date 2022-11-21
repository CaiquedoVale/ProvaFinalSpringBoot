package APIProduto.APIProduto.repository;

import APIProduto.APIProduto.entity.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Itens, Long> {
}

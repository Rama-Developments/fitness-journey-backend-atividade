package fitness.journey.backend.atividade.infrastructure.database.repositories.atividade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeEntity;

/**
 * @author stevenreis
 * @since 1.0 (16/11/24)
 */
@Repository
public interface JpaAtividadeRepository extends JpaRepository<AtividadeEntity, Long> {

}

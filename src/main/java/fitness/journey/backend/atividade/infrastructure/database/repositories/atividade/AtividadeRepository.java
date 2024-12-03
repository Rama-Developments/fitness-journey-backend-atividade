package fitness.journey.backend.atividade.infrastructure.database.repositories.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeEntity;
import fitness.journey.backend.atividade.shared.repositories.AbstractRepository;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtividadeRepository extends AbstractRepository<Atividade, AtividadeEntity> implements IAtividadeRepository {

}

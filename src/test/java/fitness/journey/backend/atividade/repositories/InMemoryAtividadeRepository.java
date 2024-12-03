package fitness.journey.backend.atividade.repositories;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public class InMemoryAtividadeRepository extends InMemoryRepository<Atividade> implements IAtividadeRepository {

}

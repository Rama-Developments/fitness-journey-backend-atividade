package fitness.journey.backend.atividade.domain.application.repositories;

import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.repositories.IRepository;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
public interface IAtividadeExecucaoRepository extends IRepository<AtividadeExecucao> {

    AtividadeExecucao findByIdAtividade(UniqueEntityId idAtividade);
}

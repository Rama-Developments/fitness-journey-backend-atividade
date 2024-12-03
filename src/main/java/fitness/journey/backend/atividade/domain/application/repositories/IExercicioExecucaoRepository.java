package fitness.journey.backend.atividade.domain.application.repositories;

import java.util.List;

import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.repositories.IRepository;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
public interface IExercicioExecucaoRepository extends IRepository<ExercicioExecucao> {

    List<ExercicioExecucao> findAllByIdAtividadeExecucao(UniqueEntityId idAtividadeExecucao);
}

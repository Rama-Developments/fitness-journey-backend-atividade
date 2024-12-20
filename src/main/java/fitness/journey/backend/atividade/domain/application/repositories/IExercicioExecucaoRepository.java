package fitness.journey.backend.atividade.domain.application.repositories;

import java.time.LocalDateTime;
import java.util.List;

import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.shared.repositories.IRepository;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
public interface IExercicioExecucaoRepository extends IRepository<ExercicioExecucao> {

    List<ExercicioExecucao> findExecucoesByDiaAndIdExercicio(Long idExercicio, LocalDateTime dtInicio, LocalDateTime dtFim);

    List<ExercicioExecucao> findExecucoesByDia(LocalDateTime dtInicio, LocalDateTime dtFim);
}

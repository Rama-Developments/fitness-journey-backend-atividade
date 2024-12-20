package fitness.journey.backend.atividade.infrastructure.http.ports;

import java.util.List;

import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioPresenter;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
public interface IHttpExercicioMapper extends HttpMapper<Exercicio, ExercicioPresenter> {

    List<ExercicioPresenter> mapFromExecucoes(List<ExercicioExecucao> execucoes);
}

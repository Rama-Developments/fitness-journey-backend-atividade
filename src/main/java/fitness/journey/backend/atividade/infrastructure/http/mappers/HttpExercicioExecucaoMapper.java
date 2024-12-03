package fitness.journey.backend.atividade.infrastructure.http.mappers;

import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioExecucaoPresenter;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Mapper
public class HttpExercicioExecucaoMapper implements HttpMapper<ExercicioExecucao, ExercicioExecucaoPresenter> {

    @Override
    public ExercicioExecucaoPresenter map(ExercicioExecucao input) {

        var presenter = new ExercicioExecucaoPresenter();

        presenter.setIdExercicioExecucao(input.getId().getAsNumber());
        presenter.setDsExercicio(input.getDsExercicio());
        presenter.setIdExercicio(input.getIdExercicio().getAsNumber());
        presenter.setNrSequencia(input.getNrSequencia());
        presenter.setQtRepeticao(input.getQtRepeticao());
        presenter.setVlCarga(input.getVlCarga());

        return presenter;
    }
}

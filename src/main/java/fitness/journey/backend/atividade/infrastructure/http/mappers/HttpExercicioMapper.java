package fitness.journey.backend.atividade.infrastructure.http.mappers;

import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioPresenter;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@Mapper
public class HttpExercicioMapper implements HttpMapper<Exercicio, ExercicioPresenter> {

    @Override
    public ExercicioPresenter map(Exercicio input) {

        var presenter = new ExercicioPresenter();

        presenter.setIdExercicio(input.getId().getAsNumber());
        presenter.setDsExercicio(input.getDsExercicio());

        return presenter;
    }
}

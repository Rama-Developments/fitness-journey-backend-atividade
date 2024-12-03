package fitness.journey.backend.atividade.infrastructure.http.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.http.presenters.AtividadePresenter;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioPresenter;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@Mapper
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HttpAtividadeMapper implements HttpMapper<Atividade, AtividadePresenter> {

    private final HttpMapper<Exercicio, ExercicioPresenter> exercicioPresenter;

    @Override
    public AtividadePresenter map(Atividade input) {

        var presenter = new AtividadePresenter();

        presenter.setIdAtividade(input.getId().getAsNumber());
        presenter.setDsAtividade(input.getDsAtividade());

        presenter.setDhCriacao(input.getDhCriacao());
        presenter.setDhAlteracao(input.getDhAlteracao());

        presenter.setExercicios(exercicioPresenter.mapList(input.getExercicios()));

        return presenter;
    }
}

package fitness.journey.backend.atividade.infrastructure.http.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.infrastructure.http.presenters.AtividadeExecucaoPresenter;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Mapper
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HttpAtividadeExecucaoMapper implements HttpMapper<AtividadeExecucao, AtividadeExecucaoPresenter> {

    private final HttpExercicioExecucaoMapper httpExercicioExecucaoMapper;

    @Override
    public AtividadeExecucaoPresenter map(AtividadeExecucao input) {

        var presenter = new AtividadeExecucaoPresenter();

        presenter.setIdAtividade(input.getIdAtividade().getAsNumber());
        presenter.setIdAtividadeExecucao(input.getId().getAsNumber());
        presenter.setDsAtividade(input.getDsAtividade());
        presenter.setExercicios(httpExercicioExecucaoMapper.mapList(input.getExercicios()));

        return presenter;
    }
}

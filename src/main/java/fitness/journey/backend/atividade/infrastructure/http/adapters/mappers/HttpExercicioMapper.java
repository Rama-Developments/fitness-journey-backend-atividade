package fitness.journey.backend.atividade.infrastructure.http.adapters.mappers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.infrastructure.http.ports.IHttpExercicioMapper;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioExecucaoPresenter;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioPresenter;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@Mapper
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HttpExercicioMapper implements IHttpExercicioMapper {

    private final @NonNull IExercicioRepository exercicioRepository;

    private final @NonNull HttpMapper<ExercicioExecucao, ExercicioExecucaoPresenter> exercicioExecucaoMapper;

    @Override
    public ExercicioPresenter map(Exercicio input) {

        var presenter = new fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioPresenter();

        presenter.setIdExercicio(input.getId().getAsNumber());
        presenter.setDsExercicio(input.getDsExercicio());

        return presenter;
    }

    @Override
    public List<ExercicioPresenter> mapFromExecucoes(List<ExercicioExecucao> execucoes) {

        List<Long> idsExercicios = execucoes.stream().map(execucao -> execucao.getIdExercicio().getAsNumber()).distinct().toList();

        List<ExercicioPresenter> exercicioPresenters = this.mapList(exercicioRepository.findMany(idsExercicios.stream().map(UniqueEntityId::createFromData).toList()));

        exercicioPresenters.forEach(exercicio -> {
            List<ExercicioExecucao> execucoesExercicio = execucoes.stream()
                    .filter(execucao -> execucao.getIdExercicio().getAsNumber().equals(exercicio.getIdExercicio())).toList();

            List<ExercicioExecucaoPresenter> execucoesPresenter = exercicioExecucaoMapper.mapList(execucoesExercicio);
            execucoesPresenter.sort(Comparator.comparing(ExercicioExecucaoPresenter::getNrSequencia));
            exercicio.setExecucoes(execucoesPresenter);
        });

        return exercicioPresenters;
    }
}

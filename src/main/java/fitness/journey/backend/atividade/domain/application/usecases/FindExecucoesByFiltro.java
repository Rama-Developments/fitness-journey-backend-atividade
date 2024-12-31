package fitness.journey.backend.atividade.domain.application.usecases;

import static fitness.journey.backend.atividade.shared.util.FiltroUtil.getCampoDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.filtro.Filtro;
import fitness.journey.backend.atividade.shared.usecases.IUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
@UseCase
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindExecucoesByFiltro implements IUseCase<Filtro, List<ExercicioExecucao>> {

    private final @NonNull IExercicioExecucaoRepository exercicioExecucaoRepository;

    @Override
    public List<ExercicioExecucao> execute(Filtro input) {

        return exercicioExecucaoRepository.findExecucoesByDia(getCampoDateTime(input, "dtInicio"), getCampoDateTime(input, "dtFim"));
    }
}

package fitness.journey.backend.atividade.domain.application.usecases;

import static java.util.Objects.isNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.ExercicioExecucaoRequestDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.exceptions.DomainException;
import fitness.journey.backend.atividade.shared.usecases.IParameteredUseCase;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (19/12/24)
 */
@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExecutarExercicio implements IParameteredUseCase<ExercicioExecucaoRequestDto, Void> {

    private final IExercicioRepository exercicioRepository;

    private final IExercicioExecucaoRepository exercicioExecucaoRepository;

    @Override
    public Void execute(ExercicioExecucaoRequestDto request) {

        var exercicio = exercicioRepository.findById(UniqueEntityId.createFromData(request.getIdExercicio()));

        var execucoesDoDia = exercicioExecucaoRepository.findExecucoesByDiaAndIdExercicio(request.getIdExercicio(),
                LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(1).atStartOfDay());

        if (isNull(exercicio)) {
            throw new DomainException("exercicio.nao.encontrado");
        }

        exercicioExecucaoRepository.create(new ExercicioExecucao(
                UniqueEntityId.createFromData(request.getIdExercicio()),
                LocalDateTime.now(),
                request.getVlCarga(),
                execucoesDoDia.size() + 1,
                request.getQtRepeticao(),
                null)
        );

        return null;
    }
}

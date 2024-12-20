package fitness.journey.backend.atividade.infrastructure.database.repositories.exercicioexecucao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioExecucaoEntity;
import fitness.journey.backend.atividade.shared.repositories.AbstractRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExercicioExecucaoRepository extends AbstractRepository<ExercicioExecucao, ExercicioExecucaoEntity> implements IExercicioExecucaoRepository {

    private final @NonNull JpaExercicioExecucaoRepository repository;

    @Override
    public List<ExercicioExecucao> findExecucoesByDiaAndIdExercicio(Long idExercicio, LocalDateTime dtInicio, LocalDateTime dtFim) {

        return repository.findExecucoesByDiaAndIdExercicio(idExercicio, dtInicio, dtFim)
                .stream()
                .map(abstractMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExercicioExecucao> findExecucoesByDia(LocalDateTime dtInicio, LocalDateTime dtFim) {

        return repository.findExecucoesByDia(dtInicio, dtFim)
                .stream()
                .map(abstractMapper::toDomain)
                .collect(Collectors.toList());
    }
}

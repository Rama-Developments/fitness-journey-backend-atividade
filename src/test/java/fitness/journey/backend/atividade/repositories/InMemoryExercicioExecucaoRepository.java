package fitness.journey.backend.atividade.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
public class InMemoryExercicioExecucaoRepository extends InMemoryRepository<ExercicioExecucao> implements IExercicioExecucaoRepository {

    @Override
    public List<ExercicioExecucao> findExecucoesByDiaAndIdExercicio(Long idExercicio, LocalDateTime dtInicio, LocalDateTime dtFim) {

        return this.items.stream()
                .filter(item -> item.getDhExecucao().isAfter(LocalDate.now().atStartOfDay()))
                .toList();
    }

    @Override
    public List<ExercicioExecucao> findExecucoesByDia(LocalDateTime dtInicio, LocalDateTime dtFim) {

        return List.of();
    }
}

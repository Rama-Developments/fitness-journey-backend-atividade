package fitness.journey.backend.atividade.infrastructure.database.repositories.exercicioexecucao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioExecucaoEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.repositories.AbstractRepository;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExercicioExecucaoRepository extends AbstractRepository<ExercicioExecucao, ExercicioExecucaoEntity> implements IExercicioExecucaoRepository {

    private final JpaExercicioExecucaoRepository repository;

    @Override
    public List<ExercicioExecucao> findAllByIdAtividadeExecucao(UniqueEntityId idAtividadeExecucao) {

        return repository.findAllByIdAtividadeExecucao(idAtividadeExecucao.getAsNumber()).stream().map(abstractMapper::toDomain).collect(Collectors.toList());
    }
}

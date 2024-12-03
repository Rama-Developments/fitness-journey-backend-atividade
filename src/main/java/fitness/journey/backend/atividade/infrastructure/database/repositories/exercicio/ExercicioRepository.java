package fitness.journey.backend.atividade.infrastructure.database.repositories.exercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioEntity;
import fitness.journey.backend.atividade.shared.repositories.AbstractRepository;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExercicioRepository extends AbstractRepository<Exercicio, ExercicioEntity> implements IExercicioRepository {

}

package fitness.journey.backend.atividade.repositories;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
public class InMemoryExercicioRepository extends InMemoryRepository<Exercicio> implements IExercicioRepository {

}

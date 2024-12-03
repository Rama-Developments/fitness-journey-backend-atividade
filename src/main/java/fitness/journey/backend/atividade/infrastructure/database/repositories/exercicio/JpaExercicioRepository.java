package fitness.journey.backend.atividade.infrastructure.database.repositories.exercicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioEntity;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@Repository
public interface JpaExercicioRepository extends JpaRepository<ExercicioEntity, Long> {

}

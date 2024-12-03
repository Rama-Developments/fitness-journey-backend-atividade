package fitness.journey.backend.atividade.infrastructure.database.repositories.exercicioexecucao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioExecucaoEntity;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Repository
public interface JpaExercicioExecucaoRepository extends JpaRepository<ExercicioExecucaoEntity, Long> {

    @Query(value = "select ee from ExercicioExecucaoEntity ee where ee.atividade.idAtividadeExecucao = ?1")
    List<ExercicioExecucaoEntity> findAllByIdAtividadeExecucao(Long idAtividadeExecucao);
}

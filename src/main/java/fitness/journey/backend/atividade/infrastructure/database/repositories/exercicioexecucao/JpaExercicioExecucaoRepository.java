package fitness.journey.backend.atividade.infrastructure.database.repositories.exercicioexecucao;

import java.time.LocalDateTime;
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

    @Query(value = "select ee from ExercicioExecucaoEntity ee where ee.exercicio.idExercicio = ?1 and ee.dhExecucao between ?2 and ?3")
    List<ExercicioExecucaoEntity> findExecucoesByDiaAndIdExercicio(Long idExercicio, LocalDateTime dtInicio, LocalDateTime dtFim);

    @Query(value = "select ee from ExercicioExecucaoEntity ee where ee.dhExecucao between ?1 and ?2")
    List<ExercicioExecucaoEntity> findExecucoesByDia(LocalDateTime dtInicio, LocalDateTime dtFim);
}

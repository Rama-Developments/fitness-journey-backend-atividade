package fitness.journey.backend.atividade.usecases;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fitness.journey.backend.atividade.domain.application.usecases.ExecutarExercicio;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.ExercicioExecucaoRequestDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.repositories.InMemoryExercicioExecucaoRepository;
import fitness.journey.backend.atividade.repositories.InMemoryExercicioRepository;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
public class ExecutarExercicioTest {

    private InMemoryExercicioRepository exercicioRepository;

    private InMemoryExercicioExecucaoRepository exercicioExecucaoRepository;

    private ExecutarExercicio sut;

    @BeforeEach
    public void setup() {
        exercicioRepository = new InMemoryExercicioRepository();
        exercicioExecucaoRepository = new InMemoryExercicioExecucaoRepository();

        sut = new ExecutarExercicio(exercicioRepository, exercicioExecucaoRepository);
    }

    @Test
    public void shouldBeAbleToExecutarExercicio() {

        Exercicio exercicio = new Exercicio("Remada curvada", null);
        exercicio.generateId();

        exercicioRepository.items.add(exercicio);

        sut.execute(new ExercicioExecucaoRequestDto(exercicio.getId().getAsNumber(), BigDecimal.TEN, 10, 1));

        Assertions.assertEquals(exercicioExecucaoRepository.items.size(), 1);
    }
}

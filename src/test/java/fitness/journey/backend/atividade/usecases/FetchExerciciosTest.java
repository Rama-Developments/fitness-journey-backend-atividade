package fitness.journey.backend.atividade.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fitness.journey.backend.atividade.domain.application.usecases.FetchExercicio;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.repositories.InMemoryExercicioRepository;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public class FetchExerciciosTest {

    private InMemoryExercicioRepository exercicioRepository;

    private FetchExercicio sut;

    @BeforeEach
    void setup() {

        exercicioRepository = new InMemoryExercicioRepository();
        sut = new FetchExercicio();
        sut.setRepository(exercicioRepository);
    }

    @Test
    void shouldFetchAtividades() {

        exercicioRepository.items.add(new Exercicio("Remada curvada", null));

        assertEquals(1, sut.execute(null).size());
    }
}

package fitness.journey.backend.atividade.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fitness.journey.backend.atividade.domain.application.usecases.FetchAtividades;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.repositories.InMemoryAtividadeRepository;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public class FetchAtividadesTest {

    private InMemoryAtividadeRepository atividadeRepository;

    private FetchAtividades sut;

    @BeforeEach
    void setup() {

        atividadeRepository = new InMemoryAtividadeRepository();
        sut = new FetchAtividades();
        sut.setRepository(atividadeRepository);
    }

    @Test
    void shouldFetchAtividades() {

        atividadeRepository.items.add(new Atividade());

        assertEquals(1, sut.execute().size());
    }
}

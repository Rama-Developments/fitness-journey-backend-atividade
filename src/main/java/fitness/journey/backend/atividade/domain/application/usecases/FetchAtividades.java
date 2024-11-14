package fitness.journey.backend.atividade.domain.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FetchAtividades {

    private final IAtividadeRepository atividadeRepository;

    public List<Atividade> execute() {

        return atividadeRepository.fetch();
    }
}

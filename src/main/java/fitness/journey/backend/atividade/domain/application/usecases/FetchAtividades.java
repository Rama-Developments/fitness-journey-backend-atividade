package fitness.journey.backend.atividade.domain.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.usecases.AbstractFetchUseCase;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FetchAtividades extends AbstractFetchUseCase<Atividade> {}

package fitness.journey.backend.atividade.domain.application.usecases;

import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.usecases.AbstractCreateUseCase;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
@UseCase
public class CreateAtividade extends AbstractCreateUseCase<Atividade> {}

package fitness.journey.backend.atividade.domain.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeExecucaoRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.usecases.IParameteredUseCase;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FindOneExecucao implements IParameteredUseCase<Long, AtividadeExecucao> {

    private final IAtividadeExecucaoRepository atividadeExecucaoRepository;

    @Override
    public AtividadeExecucao execute(Long input) {

        return atividadeExecucaoRepository.findById(UniqueEntityId.createFromData(input));
    }
}

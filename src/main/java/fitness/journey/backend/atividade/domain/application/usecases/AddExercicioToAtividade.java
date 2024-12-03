package fitness.journey.backend.atividade.domain.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.usecases.dtos.AddExercicioToAtividadeRequestDto;
import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeRepository;
import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.application.usecases.validators.AddExercicioToAtividadeValidator;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.exceptions.DomainException;
import fitness.journey.backend.atividade.shared.usecases.IParameteredUseCase;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddExercicioToAtividade implements IParameteredUseCase<AddExercicioToAtividadeRequestDto, Atividade> {

    private final IExercicioRepository exercicioRepository;

    private final IAtividadeRepository atividadeRepository;

    private final AddExercicioToAtividadeValidator validator;

    @Override
    public Atividade execute(AddExercicioToAtividadeRequestDto request) {

        validator.validate(request);

        Atividade atividade = atividadeRepository.findById(UniqueEntityId.createFromData(request.idAtividade));

        if (atividade == null) {
            throw new DomainException("atividade.nao.encontrada");
        }

        List<Exercicio> exercicios = exercicioRepository.findMany(getIdsExercicio(request));

        exercicios.forEach(atividade::addExercicio);

        return atividadeRepository.update(atividade);
    }

    private List<UniqueEntityId> getIdsExercicio(AddExercicioToAtividadeRequestDto request) {

        return request.idsExercicio.stream().map(UniqueEntityId::createFromData).toList();
    }
}

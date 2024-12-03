package fitness.journey.backend.atividade.domain.application.usecases.validators;

import org.springframework.stereotype.Component;

import fitness.journey.backend.atividade.domain.application.usecases.dtos.AddExercicioToAtividadeRequestDto;
import fitness.journey.backend.atividade.shared.exceptions.DomainException;
import fitness.journey.backend.atividade.shared.validator.UseCaseValidator;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Component
public class AddExercicioToAtividadeValidator implements UseCaseValidator<AddExercicioToAtividadeRequestDto> {


    @Override
    public void validate(AddExercicioToAtividadeRequestDto request) {

        if (request.idAtividade == null) throw new DomainException("idAtividade.notnull");

        if (request.idsExercicio == null) throw new DomainException("idsExercicio.notnull");

        if (request.idsExercicio.isEmpty()) throw new DomainException("idsExercicio.notempty");
    }
}

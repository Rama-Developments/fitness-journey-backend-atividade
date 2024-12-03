package fitness.journey.backend.atividade.domain.application.usecases.dtos;

import java.util.List;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
public class AddExercicioToAtividadeRequestDto {

    public Long idAtividade;

    public List<Long> idsExercicio;
}

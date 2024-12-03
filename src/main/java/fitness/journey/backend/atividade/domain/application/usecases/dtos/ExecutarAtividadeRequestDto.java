package fitness.journey.backend.atividade.domain.application.usecases.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@Getter
@Setter
public class ExecutarAtividadeRequestDto {

    private Long idAtividade;

    private List<ExercicioExecucaoRequestDto> execucoes;

    private LocalDateTime dhInicio;

    private LocalDateTime dhFim;
}

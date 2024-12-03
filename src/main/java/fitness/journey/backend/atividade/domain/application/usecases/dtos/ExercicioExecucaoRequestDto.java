package fitness.journey.backend.atividade.domain.application.usecases.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@Getter
@Setter
public class ExercicioExecucaoRequestDto {

    private Long idExercicio;

    private BigDecimal vlCarga;

    private Integer qtRepeticao;

    private Integer nrSequencia;
}

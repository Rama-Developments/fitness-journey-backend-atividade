package fitness.journey.backend.atividade.infrastructure.http.presenters;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Getter
@Setter
public class ExercicioExecucaoPresenter {

    private Long idExercicio;

    private BigDecimal vlCarga;

    private Integer qtRepeticao;

    private Integer nrSequencia;
}

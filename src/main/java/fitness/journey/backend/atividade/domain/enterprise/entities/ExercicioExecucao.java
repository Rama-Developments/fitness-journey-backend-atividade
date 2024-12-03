package fitness.journey.backend.atividade.domain.enterprise.entities;

import java.math.BigDecimal;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioExecucao extends AbstractEntity {

    private UniqueEntityId idAtividadeExecucao;

    private UniqueEntityId idExercicio;

    private String dsExercicio;

    private BigDecimal vlCarga;

    private Integer nrSequencia;

    private Integer qtRepeticao;

    private String dsObservacao;
}

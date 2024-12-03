package fitness.journey.backend.atividade.domain.enterprise.entities;

import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.exceptions.DomainException;
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
public class AtividadeExecucao extends AbstractEntity {

    private UniqueEntityId idAtividade;

    private String dsAtividade;

    private List<ExercicioExecucao> exercicios;

    private LocalDateTime dhInicio;

    private LocalDateTime dhFim;

    private String dsObservacao;

    public void addExercicio(ExercicioExecucao exercicio) {

        if (isNull(exercicio)) {
            throw new DomainException("exercicio.nao.existe");
        }

        if (isNull(exercicios)) {
            this.exercicios = new ArrayList<>();
        }

        exercicio.setNrSequencia(this.exercicios.size() + 1);

        this.exercicios.add(exercicio);
    }

    public void setExercicios(List<ExercicioExecucao> exercicios) {

        this.exercicios = new ArrayList<>();

        exercicios.forEach(this::addExercicio);
    }
}

package fitness.journey.backend.atividade.domain.enterprise.entities;

import java.util.ArrayList;
import java.util.List;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atividade extends AbstractEntity {

    private String dsAtividade;

    private List<Exercicio> exercicios = new ArrayList<>();

    public void addExercicio(Exercicio exercicio) {

        if (exercicios == null) {
            exercicios = new ArrayList<>();
        }

        if (hasExercicio(exercicio)) {
            return;
        }

        exercicios.add(exercicio);

        touch();
    }

    private boolean hasExercicio(Exercicio exercicio) {

        return this.exercicios.stream().anyMatch(item -> item.getId().getAsNumber().equals(exercicio.getId().getAsNumber()));
    }
}

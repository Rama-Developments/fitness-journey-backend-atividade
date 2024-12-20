package fitness.journey.backend.atividade.infrastructure.http.presenters;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@Getter
@Setter
public class ExercicioPresenter {

    private Long idExercicio;

    private String dsExercicio;

    private List<ExercicioExecucaoPresenter> execucoes;
}

package fitness.journey.backend.atividade.infrastructure.http.presenters;

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
public class AtividadePresenter {

    private Long idAtividade;

    private String dsAtividade;

    private LocalDateTime dhCriacao;

    private LocalDateTime dhAlteracao;

    private List<ExercicioPresenter> exercicios;
}

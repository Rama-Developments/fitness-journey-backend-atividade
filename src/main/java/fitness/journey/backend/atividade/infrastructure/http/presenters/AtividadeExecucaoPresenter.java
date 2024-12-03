package fitness.journey.backend.atividade.infrastructure.http.presenters;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Getter
@Setter
public class AtividadeExecucaoPresenter {

    private Long idAtividadeExecucao;

    private Long idAtividade;

    private String dsAtividade;

    private List<ExercicioExecucaoPresenter> exercicios;

    private LocalDateTime dhInicio;

    private LocalDateTime dhFim;
}

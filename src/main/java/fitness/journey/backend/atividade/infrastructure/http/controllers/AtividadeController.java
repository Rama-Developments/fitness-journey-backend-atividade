package fitness.journey.backend.atividade.infrastructure.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitness.journey.backend.atividade.domain.application.usecases.ExecutarAtividade;
import fitness.journey.backend.atividade.domain.application.usecases.FindOneExecucao;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.AddExercicioToAtividadeRequestDto;
import fitness.journey.backend.atividade.domain.application.usecases.AddExercicioToAtividade;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.ExecutarAtividadeRequestDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.infrastructure.http.mappers.HttpAtividadeExecucaoMapper;
import fitness.journey.backend.atividade.infrastructure.http.presenters.AtividadePresenter;
import fitness.journey.backend.atividade.shared.http.controllers.AbstractController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@RestController
@RequestMapping("atividade")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtividadeController extends AbstractController<Atividade, AtividadePresenter> {

    private final AddExercicioToAtividade addExercicioToAtividade;

    private final ExecutarAtividade executarAtividade;

    private final FindOneExecucao findOneExecucao;

    private final HttpAtividadeExecucaoMapper httpAtividadeExecucaoMapper;

    @PostMapping("add-exercicio")
    public ResponseEntity addExercicio(@Valid @RequestBody AddExercicioToAtividadeRequestDto request) {

        var atividade = addExercicioToAtividade.execute(request);

        return ok(atividade);
    }

    @PostMapping("executar")
    public ResponseEntity executar(@Valid @RequestBody ExecutarAtividadeRequestDto request) {

        return ok(executarAtividade.execute(request));
    }

    @GetMapping("execucao/{idAtividadeExecucao}")
    public ResponseEntity execucao(@PathVariable Long idAtividadeExecucao) {

        return ok(httpAtividadeExecucaoMapper.map(findOneExecucao.execute(idAtividadeExecucao)));
    }
}

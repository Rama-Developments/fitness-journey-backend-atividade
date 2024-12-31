package fitness.journey.backend.atividade.infrastructure.http.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fitness.journey.backend.atividade.domain.application.usecases.CreateExercicio;
import fitness.journey.backend.atividade.domain.application.usecases.ExecutarExercicio;
import fitness.journey.backend.atividade.domain.application.usecases.FetchExercicio;
import fitness.journey.backend.atividade.domain.application.usecases.FindExecucoesByFiltro;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.ExercicioExecucaoRequestDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.http.ports.IHttpExercicioMapper;
import fitness.journey.backend.atividade.shared.filtro.Filtro;
import fitness.journey.backend.atividade.shared.http.controllers.AbstractController;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@RestController
@RequestMapping("exercicio")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExercicioController extends AbstractController<Exercicio, Exercicio> {

    private final IHttpExercicioMapper exercicioMapper;

    private final ExecutarExercicio executarExercicio;

    private final FindExecucoesByFiltro findExecucoesByFiltro;

    private final FetchExercicio fetchExercicio;

    private final CreateExercicio createExercicio;

    @Override
    public ResponseEntity findAll() {

        List<Exercicio> exercicios = fetchExercicio.execute();

        return ok(exercicioMapper.mapList(exercicios));
    }

    @Override
    public ResponseEntity create(Exercicio entity) {

        return created(exercicioMapper.map(createExercicio.execute(entity)));
    }

    @PostMapping("executar")
    public ResponseEntity executar(@RequestBody ExercicioExecucaoRequestDto exercicio) {

        executarExercicio.execute(exercicio);

        return created(null);
    }

    @GetMapping("execucoes")
    public ResponseEntity fetchExecucoes(@RequestParam Map<String, Object> params) {

        return ok(exercicioMapper.mapFromExecucoes(findExecucoesByFiltro.execute(getFiltro(params))));
    }

    private Filtro getFiltro(Map<String, Object> params) {

        Filtro filtro = new Filtro();
        filtro.addClausula("dtInicio", params.get("dtInicio"));
        filtro.addClausula("dtFim", params.get("dtFim"));

        return filtro;
    }
}

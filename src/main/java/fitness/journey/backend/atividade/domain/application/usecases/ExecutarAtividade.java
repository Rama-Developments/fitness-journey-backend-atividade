package fitness.journey.backend.atividade.domain.application.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeExecucaoRepository;
import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeRepository;
import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.ExecutarAtividadeRequestDto;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.ExercicioExecucaoRequestDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.exceptions.DomainException;
import fitness.journey.backend.atividade.shared.usecases.IParameteredUseCase;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExecutarAtividade implements
        IParameteredUseCase<ExecutarAtividadeRequestDto, AtividadeExecucao> {

    private final IAtividadeRepository atividadeRepository;

    private final IExercicioRepository exercicioRepository;

    private final IExercicioExecucaoRepository exercicioExecucaoRepository;

    private final IAtividadeExecucaoRepository atividadeExecucaoRepository;

    @Override
    public AtividadeExecucao execute(ExecutarAtividadeRequestDto request) {

        Atividade atividade = atividadeRepository.findById(UniqueEntityId.createFromData(request.getIdAtividade()));

        if (atividade == null) {

            throw new DomainException("atividade.nao.encontrada");
        }

        List<ExercicioExecucao> exercicios = findExercicios(request);

        var execucaoAtividade = new AtividadeExecucao();
        execucaoAtividade.setExercicios(exercicios);
        execucaoAtividade.setIdAtividade(atividade.getId());
        execucaoAtividade.setDhInicio(request.getDhInicio());
        execucaoAtividade.setDhFim(request.getDhFim());

        atividadeExecucaoRepository.create(execucaoAtividade);

        return execucaoAtividade;
    }

    private List<ExercicioExecucao> findExercicios(ExecutarAtividadeRequestDto request) {

        List<Long> idsExercicio = request.getExecucoes().stream().map(ExercicioExecucaoRequestDto::getIdExercicio).toList();

        List<Exercicio> exercicios = exercicioRepository.findMany(idsExercicio.stream().map(UniqueEntityId::createFromData).toList());

        var execucoes = new ArrayList<ExercicioExecucao>();

        exercicios.forEach(exercicio -> {

            var execucao = new ExercicioExecucao();

            Optional<ExercicioExecucaoRequestDto> execucaoRequest = request.getExecucoes().stream()
                    .filter(item -> item.getIdExercicio().equals(exercicio.getId().getAsNumber())).findFirst();

            execucaoRequest.ifPresent(item -> {

                execucao.setIdExercicio(exercicio.getId());
                execucao.setNrSequencia(item.getNrSequencia());
                execucao.setVlCarga(item.getVlCarga());
                execucao.setQtRepeticao(item.getQtRepeticao());
            });

            execucoes.add(execucao);
        });

        return execucoes;
    }
}

package fitness.journey.backend.atividade.domain.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.application.repositories.IExercicioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.usecases.IUseCase;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FindManyExercicios implements IUseCase<List<UniqueEntityId>, List<Exercicio>> {

    private final IExercicioRepository exercicioRepository;

    @Override
    public List<Exercicio> execute(List<UniqueEntityId> input){

        return List.of();
    }
}

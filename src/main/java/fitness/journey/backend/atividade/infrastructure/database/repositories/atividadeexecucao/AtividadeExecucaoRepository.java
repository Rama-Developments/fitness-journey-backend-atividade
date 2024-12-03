package fitness.journey.backend.atividade.infrastructure.database.repositories.atividadeexecucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeExecucaoRepository;
import fitness.journey.backend.atividade.domain.application.repositories.IExercicioExecucaoRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeExecucaoEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.repositories.AbstractRepository;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtividadeExecucaoRepository extends AbstractRepository<AtividadeExecucao, AtividadeExecucaoEntity> implements IAtividadeExecucaoRepository {

    private final JpaAtividadeExecucaoRepository repository;

    private final IExercicioExecucaoRepository exercicioRepository;

    @Override
    public AtividadeExecucao create(AtividadeExecucao entity) {

        AtividadeExecucao atividadeExecucao = abstractMapper.toDomain(repository.save(abstractMapper.toDb(entity)));

        entity.getExercicios().forEach(exercicio -> exercicio.setIdAtividadeExecucao(atividadeExecucao.getId()));

        entity.getExercicios().forEach(exercicioRepository::create);

        return atividadeExecucao;
    }

    @Override
    public AtividadeExecucao findByIdAtividade(UniqueEntityId idAtividade) {

        return abstractMapper.toDomain(repository.findByidAtividade(idAtividade.getAsNumber()));
    }

    @Override
    public AtividadeExecucao findById(UniqueEntityId id) {

        AtividadeExecucao atividadeExecucao = super.findById(id);

        atividadeExecucao.setExercicios(exercicioRepository.findAllByIdAtividadeExecucao(id));

        return atividadeExecucao;
    }
}

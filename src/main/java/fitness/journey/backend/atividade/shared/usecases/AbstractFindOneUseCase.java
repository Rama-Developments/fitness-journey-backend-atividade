package fitness.journey.backend.atividade.shared.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.repositories.IRepository;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (19/12/24)
 */
public class AbstractFindOneUseCase<T extends AbstractEntity> implements IParameteredUseCase<Long, T> {

    @Setter
    @Autowired(required = false)
    protected IRepository<T> repository;

    @Override
    public T execute(Long id) {

        return repository.findById(UniqueEntityId.createFromData(id));
    }
}

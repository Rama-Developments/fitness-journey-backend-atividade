package fitness.journey.backend.atividade.shared.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.repositories.IRepository;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
public class AbstractFetchUseCase<T extends AbstractEntity> implements IUseCase<List<T>> {

    @Setter
    @Autowired(required = false)
    protected IRepository<T> repository;

    @Override
    public List<T> execute() {

        return repository.fetch();
    }
}

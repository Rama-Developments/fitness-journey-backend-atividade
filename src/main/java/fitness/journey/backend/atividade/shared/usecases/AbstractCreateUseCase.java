package fitness.journey.backend.atividade.shared.usecases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.repositories.IRepository;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
public class AbstractCreateUseCase<T extends AbstractEntity> implements IParameteredUseCase<T, T> {

    @Autowired(required = false)
    protected IRepository<T> repository;

    @Override
    public T execute(T input) throws Exception {

        if (input.getId() == null) input.generateId();

        input.setDhCriacao(LocalDateTime.now());
        input.setDhAlteracao(LocalDateTime.now());

        return this.repository.create(input);
    }
}

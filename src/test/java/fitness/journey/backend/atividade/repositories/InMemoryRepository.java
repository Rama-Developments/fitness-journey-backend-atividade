package fitness.journey.backend.atividade.repositories;

import java.util.ArrayList;
import java.util.List;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.repositories.IRepository;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public class InMemoryRepository<T extends AbstractEntity> implements IRepository<T> {

    public List<T> items = new ArrayList<>();

    @Override
    public List<T> fetch() {

        return this.items;
    }

    @Override
    public T findById(UniqueEntityId id) {

        return this.items.stream().filter(item -> item.getId().getAsNumber().equals(id.getAsNumber())).findFirst().orElse(null);
    }

    @Override
    public T create(T entity) {

        this.items.add(entity);

        return entity;
    }

    @Override
    public T update(T entity) {

        return null;
    }

    @Override
    public List<T> findMany(List<UniqueEntityId> ids) {

        return List.of();
    }
}

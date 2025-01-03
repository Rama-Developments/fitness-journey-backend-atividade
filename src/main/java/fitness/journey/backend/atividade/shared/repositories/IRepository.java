package fitness.journey.backend.atividade.shared.repositories;

import java.util.List;

import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public interface IRepository<T> {

    List<T> fetch();

    T findById(UniqueEntityId id);

    T create(T entity);

    T update(T entity);

    List<T> findMany(List<UniqueEntityId> ids);
}

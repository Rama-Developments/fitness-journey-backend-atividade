package fitness.journey.backend.atividade.infrastructure.database.repositories;

import java.util.List;

import fitness.journey.backend.atividade.shared.repositories.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.mapper.AbstractMapper;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
public class AbstractRepository<T extends AbstractEntity, K> implements IRepository<T> {

    @Autowired(required = false)
    protected JpaRepository<K, Long> abstractRepository;

    @Autowired(required = false)
    protected AbstractMapper<T, K> abstractMapper;

    @Override
    public List<T> fetch() {

        return abstractRepository.findAll()
                .stream()
                .map(abstractMapper::toDomain)
                .toList();
    }

    @Override
    public T findById(UniqueEntityId id) {

        return abstractMapper.toDomain(abstractRepository.findById(id.getAsNumber()).orElse(null));
    }

    @Override
    public T create(T entity) {

        return abstractMapper.toDomain(abstractRepository.save(abstractMapper.toDb(entity)));
    }

    @Override
    public T update(T entity) {

        return abstractMapper.toDomain(abstractRepository.saveAndFlush(abstractMapper.toDb(entity)));
    }

    @Override
    public List<T> findMany(List<UniqueEntityId> ids) {

        return abstractRepository.findAllById(ids.stream().map(UniqueEntityId::getAsNumber).toList())
                .stream()
                .map(abstractMapper::toDomain)
                .toList();
    }
}

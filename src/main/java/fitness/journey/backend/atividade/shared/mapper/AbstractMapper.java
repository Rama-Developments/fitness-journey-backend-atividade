package fitness.journey.backend.atividade.shared.mapper;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
public interface AbstractMapper<T, K> {

    T toDomain(K entity);

    K toDb(T domain);
}

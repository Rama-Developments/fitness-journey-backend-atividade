package fitness.journey.backend.atividade.shared.mapper;

import java.util.List;

/**
 * @author stevenreis
 * @since 1.0 (29/11/24)
 */
public interface HttpMapper<I, O> {

    O map(I input);

    default List<O> mapList(List<I> input) {

        return input.stream().map(this::map).toList();
    }
}

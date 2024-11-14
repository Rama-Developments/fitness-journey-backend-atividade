package fitness.journey.backend.atividade.shared.entities;

import static java.util.Objects.isNull;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@Getter
@Setter
public class UniqueEntityId<T> {

    private static Long count = 0L;

    private T value;

    private UniqueEntityIdType tpUniqueEntityId;

    private UniqueEntityId(T value) throws Exception {

        this.value = value;
        this.tpUniqueEntityId = getTypeByValue(value);
    }

    public static UniqueEntityId createFromData(Object value) throws Exception{

        if (isNull(value)) return null;

        if (value instanceof String)
            return new UniqueEntityId<>(String.valueOf(value));

        return new UniqueEntityId<>(Long.valueOf(value.toString()));
    }

    public static UniqueEntityId generate(UniqueEntityIdType type) throws Exception {

        return new UniqueEntityId<>(UniqueEntityIdType.UUID.equals(type) ? UUID.randomUUID() : count);
    }

    private static UniqueEntityIdType getTypeByValue(Object value) throws Exception {

        if (value instanceof String) {

            return UniqueEntityIdType.UUID;
        } else if (value instanceof Long) {

            return UniqueEntityIdType.BIG_INT;
        }

        throw new Exception("Tipo de dado não suportado para id");
    }
}

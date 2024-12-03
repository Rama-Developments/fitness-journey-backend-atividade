package fitness.journey.backend.atividade.shared.entities;

import static java.util.Objects.isNull;

import java.util.UUID;

import fitness.journey.backend.atividade.shared.exceptions.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniqueEntityId<T> {

    private T value;

    private UniqueEntityIdType tpUniqueEntityId;

    private UniqueEntityId(T value) {

        this.value = value;
        this.tpUniqueEntityId = getTypeByValue(value);
    }

    public Long getAsNumber() {

        return UniqueEntityIdType.BIG_INT.equals(tpUniqueEntityId)
                ? Long.valueOf(value.toString())
                : null;
    }

    public static UniqueEntityId createFromData(Object value) {

        if (isNull(value)) return null;

        if (value instanceof String)
            return new UniqueEntityId<>(String.valueOf(value));

        return new UniqueEntityId<>(Long.valueOf(value.toString()));
    }

    public static UniqueEntityId generate(UniqueEntityIdType type) {

        return new UniqueEntityId<>(UniqueEntityIdType.UUID.equals(type) ? UUID.randomUUID() : -1L);
    }

    private static UniqueEntityIdType getTypeByValue(Object value) {

        if (value instanceof String) {

            return UniqueEntityIdType.UUID;
        } else if (value instanceof Long) {

            return UniqueEntityIdType.BIG_INT;
        }

        throw new DomainException("Tipo de dado não suportado para id");
    }
}

package fitness.journey.backend.atividade.shared.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
@Getter
@AllArgsConstructor
public enum UniqueEntityIdType {

    BIG_INT("BigInt", Long.class),

    UUID("Uuid", String.class);

    private final String dsChave;

    private final Class cdClass;
}

package fitness.journey.backend.atividade.shared.entities;

import java.time.LocalDateTime;

import lombok.Getter;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public class AbstractEntity<T> {

    protected UniqueEntityId<T> _id;

    protected @Getter LocalDateTime dhCriacao;

    protected @Getter LocalDateTime dhAlteracao;

    public UniqueEntityId getId() {

        return this._id;
    }
}

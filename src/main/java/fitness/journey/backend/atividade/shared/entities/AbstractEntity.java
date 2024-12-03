package fitness.journey.backend.atividade.shared.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (14/11/24)
 */
public class AbstractEntity {

    protected UniqueEntityId _id;

    protected @Getter @Setter LocalDateTime dhCriacao;

    protected @Getter @Setter LocalDateTime dhAlteracao;

    public UniqueEntityId getId() {

        return this._id;
    }

    public void setId(UniqueEntityId id) {

        this._id = id;
    }

    public void generateId() {

        this._id = UniqueEntityId.generate(UniqueEntityIdType.BIG_INT);
    }

    protected void touch() {

        this.dhAlteracao = LocalDateTime.now();
    }
}

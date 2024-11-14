package fitness.journey.backend.atividade.domain.enterprise.entities;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
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
@NoArgsConstructor
@AllArgsConstructor
public class Atividade extends AbstractEntity<Long> {

    public String dsAtividade;
}

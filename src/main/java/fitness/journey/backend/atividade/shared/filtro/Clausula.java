package fitness.journey.backend.atividade.shared.filtro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
@Getter
@Setter
@AllArgsConstructor
public class Clausula {

    private String key;

    private Object value;
}

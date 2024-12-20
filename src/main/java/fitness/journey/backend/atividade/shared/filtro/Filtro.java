package fitness.journey.backend.atividade.shared.filtro;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
@Getter
@Setter
public class Filtro {

    private List<Clausula> clausulas;

    public void addClausula(Clausula clausula) {
        if (this.clausulas == null) {
            this.clausulas = new ArrayList<>();
        }
        this.clausulas.add(clausula);
    }

    public void addClausula(String key, Object value) {
        if (this.clausulas == null) {
            this.clausulas = new ArrayList<>();
        }
        this.clausulas.add(new Clausula(key, value));
    }
}

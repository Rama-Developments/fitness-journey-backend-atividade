package fitness.journey.backend.atividade.shared.util;

import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fitness.journey.backend.atividade.shared.filtro.Clausula;
import fitness.journey.backend.atividade.shared.filtro.Filtro;

/**
 * @author stevenreis
 * @since 1.0 (20/12/24)
 */
public class FiltroUtil {

    public static LocalDateTime getCampoDateTime(Filtro filtro, String campo) {

        if (isNull(filtro)) {
            return null;
        }

        Clausula clausulaFromFiltro = filtro.getClausulas().stream().filter(clausula -> clausula.getKey().equals(campo)).findFirst().orElse(null);

        return isNull(clausulaFromFiltro) || isNull(clausulaFromFiltro.getValue()) ? null : LocalDateTime.parse(clausulaFromFiltro.getValue().toString(), DateTimeFormatter.ISO_DATE_TIME);
    }

    public static Long getCampoLong(Filtro filtro, String campo) {

        if (isNull(filtro)) {
            return null;
        }

        Clausula clausulaFromFiltro = filtro.getClausulas().stream().filter(clausula -> clausula.getKey().equals(campo)).findFirst().orElse(null);

        return isNull(clausulaFromFiltro) || isNull(clausulaFromFiltro.getValue()) ? null : Long.parseLong(clausulaFromFiltro.getValue().toString());
    }
}

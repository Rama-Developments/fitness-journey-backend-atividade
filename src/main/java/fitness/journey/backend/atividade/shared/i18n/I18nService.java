package fitness.journey.backend.atividade.shared.i18n;

/**
 * @author stevenreis
 * @since 1.0 (22/11/24)
 */
public interface I18nService {

    String i(String message);

    String i(String message, Object... args);
}

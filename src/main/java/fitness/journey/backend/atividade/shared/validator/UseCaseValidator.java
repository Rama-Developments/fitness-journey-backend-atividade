package fitness.journey.backend.atividade.shared.validator;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
public interface UseCaseValidator<T> {

    void validate(T useCase);
}

package fitness.journey.backend.atividade.shared.usecases;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
public interface IParameteredUseCase<I, O> {

    O execute(I input) throws Exception;
}

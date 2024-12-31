package fitness.journey.backend.atividade.shared.usecases;

import fitness.journey.backend.atividade.shared.session.UsuarioSessionContextHolder;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
public interface IUseCase<I, O> {

    O execute(I input);

    default Long getIdUsuarioLogado() {

        return UsuarioSessionContextHolder.getIdUsuarioLogado();
    }
}

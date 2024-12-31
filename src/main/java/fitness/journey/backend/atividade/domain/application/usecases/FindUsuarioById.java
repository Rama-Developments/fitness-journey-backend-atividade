package fitness.journey.backend.atividade.domain.application.usecases;

import fitness.journey.backend.atividade.domain.application.repositories.IUsuarioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.usecases.IUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindUsuarioById implements IUseCase<Long, Usuario> {

    private final @NonNull IUsuarioRepository usuarioRepository;

    @Override
    public Usuario execute(Long idUsuario) {

        return usuarioRepository.findById(UniqueEntityId.createFromData(idUsuario));
    }
}

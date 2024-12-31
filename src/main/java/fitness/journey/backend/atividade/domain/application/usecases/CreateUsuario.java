package fitness.journey.backend.atividade.domain.application.usecases;

import fitness.journey.backend.atividade.domain.application.repositories.IUsuarioRepository;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.CreateUsuarioRequestDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.usecases.IUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCase
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateUsuario implements IUseCase<CreateUsuarioRequestDto, Usuario> {

    private final @NonNull IUsuarioRepository repository;

    private final @NonNull PasswordEncoder passwordEncoder;

    @Override
    public Usuario execute(CreateUsuarioRequestDto input) {

        var usuario = new Usuario(
                input.getDsNome(),
                passwordEncoder.encode(input.getDsSenha()),
                input.getDsEmail()
        );

        usuario.generateId();

        return repository.create(usuario);
    }
}

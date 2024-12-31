package fitness.journey.backend.atividade.domain.application.usecases;

import fitness.journey.backend.atividade.domain.application.repositories.IUsuarioRepository;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.AuthenticationRequestDto;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.AuthenticationResponseDto;
import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.infrastructure.services.JwtService;
import fitness.journey.backend.atividade.shared.annotations.UseCase;
import fitness.journey.backend.atividade.shared.usecases.IUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@UseCase
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticateUsuario implements IUseCase<AuthenticationRequestDto, AuthenticationResponseDto> {

    private final @NonNull AuthenticationManager authenticationManager;

    private final @NonNull JwtService jwtService;

    private final @NonNull IUsuarioRepository usuarioRepository;

    @Override
    public AuthenticationResponseDto execute(AuthenticationRequestDto input) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(input.getDsEmail(), input.getDsSenha());

        return new AuthenticationResponseDto(
                usuarioRepository.findByEmail(input.getDsEmail()),
                jwtService.generateToken((Usuario) authenticationManager.authenticate(usernamePassword).getPrincipal())
        );
    }
}

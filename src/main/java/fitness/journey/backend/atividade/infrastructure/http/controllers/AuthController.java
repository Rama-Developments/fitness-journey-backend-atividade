package fitness.journey.backend.atividade.infrastructure.http.controllers;

import fitness.journey.backend.atividade.domain.application.usecases.AuthenticateUsuario;
import fitness.journey.backend.atividade.domain.application.usecases.CreateUsuario;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.AuthenticationRequestDto;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.CreateUsuarioRequestDto;
import fitness.journey.backend.atividade.infrastructure.http.controllers.response.DefaultResponseEntity;
import fitness.journey.backend.atividade.infrastructure.http.controllers.response.LoginResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final @NonNull AuthenticateUsuario authenticateUsuario;

    private final @NonNull CreateUsuario createUsuario;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto body) {

        return ResponseEntity.ok(new LoginResponse(authenticateUsuario.execute(body)));
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody CreateUsuarioRequestDto body) {

        return DefaultResponseEntity.created(createUsuario.execute(body));
    }
}

package fitness.journey.backend.atividade.infrastructure.http.controllers;

import fitness.journey.backend.atividade.domain.application.usecases.CreateUsuario;
import fitness.journey.backend.atividade.domain.application.usecases.FindUsuarioById;
import fitness.journey.backend.atividade.domain.application.usecases.dtos.CreateUsuarioRequestDto;
import fitness.journey.backend.atividade.infrastructure.http.ports.IHttpUsuarioMapper;
import fitness.journey.backend.atividade.shared.http.controllers.DefaultResponseEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private final @NonNull CreateUsuario createUsuario;

    private final @NonNull FindUsuarioById findUsuarioById;

    private final @NonNull IHttpUsuarioMapper usuarioMapper;

    @GetMapping("{idUsuario}")
    public ResponseEntity findById(@PathVariable Long idUsuario) {

        return new DefaultResponseEntity(usuarioMapper.map(findUsuarioById.execute(idUsuario)));
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody CreateUsuarioRequestDto body) {

        return DefaultResponseEntity.created(usuarioMapper.map(createUsuario.execute(body)));
    }
}


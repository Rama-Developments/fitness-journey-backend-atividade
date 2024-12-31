package fitness.journey.backend.atividade.infrastructure.http.controllers;

import fitness.journey.backend.atividade.domain.application.usecases.CreateUsuario;
import fitness.journey.backend.atividade.domain.application.usecases.FindUsuarioById;
import fitness.journey.backend.atividade.infrastructure.http.controllers.response.DefaultResponseEntity;
import fitness.journey.backend.atividade.infrastructure.http.ports.IHttpUsuarioMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


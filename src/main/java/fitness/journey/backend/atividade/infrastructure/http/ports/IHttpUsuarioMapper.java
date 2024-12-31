package fitness.journey.backend.atividade.infrastructure.http.ports;

import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.infrastructure.http.presenters.UsuarioPresenter;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;

public interface IHttpUsuarioMapper extends HttpMapper<Usuario, UsuarioPresenter> {
}

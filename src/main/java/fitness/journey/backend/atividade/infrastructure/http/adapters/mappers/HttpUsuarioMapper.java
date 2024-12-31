package fitness.journey.backend.atividade.infrastructure.http.adapters.mappers;

import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.infrastructure.http.ports.IHttpUsuarioMapper;
import fitness.journey.backend.atividade.infrastructure.http.presenters.UsuarioPresenter;
import fitness.journey.backend.atividade.shared.annotations.Mapper;

@Mapper
public class HttpUsuarioMapper implements IHttpUsuarioMapper {

    @Override
    public UsuarioPresenter map(Usuario input) {

        var presenter = new UsuarioPresenter();

        presenter.setIdUsuario(input.getId().getAsNumber());
        presenter.setDsEmail(input.getDsEmail());
        presenter.setDsNome(input.getDsNome());

        return presenter;
    }
}

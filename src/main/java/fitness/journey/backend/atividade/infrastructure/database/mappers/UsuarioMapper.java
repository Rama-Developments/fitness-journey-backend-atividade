package fitness.journey.backend.atividade.infrastructure.database.mappers;

import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.infrastructure.database.entities.UsuarioEntity;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.mapper.AbstractMapper;

@Mapper
public class UsuarioMapper implements AbstractMapper<Usuario, UsuarioEntity> {

    @Override
    public Usuario toDomain(UsuarioEntity entity) {

        var domain = new Usuario();

        domain.setDsEmail(entity.getDsEmail());
        domain.setDsNome(entity.getDsNome());
        domain.setDsSenha(entity.getDsSenha());
        domain.setId(UniqueEntityId.createFromData(entity.getIdUsuario()));

        return domain;
    }

    @Override
    public UsuarioEntity toDb(Usuario domain) {

        var entity = new UsuarioEntity();

        entity.setDsNome(domain.getDsNome());
        entity.setDsEmail(domain.getDsEmail());
        entity.setDsSenha(domain.getDsSenha());
        entity.setIdUsuario(domain.getId().getAsNumber());

        return entity;
    }
}

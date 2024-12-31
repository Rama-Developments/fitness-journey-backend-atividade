package fitness.journey.backend.atividade.infrastructure.database.repositories.usuario;

import fitness.journey.backend.atividade.domain.application.repositories.IUsuarioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.infrastructure.database.entities.UsuarioEntity;
import fitness.journey.backend.atividade.infrastructure.database.repositories.AbstractRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioRepository extends AbstractRepository<Usuario, UsuarioEntity> implements IUsuarioRepository {

    private final @NonNull JpaUsuarioRepository db;

    @Override
    public Usuario findByNome(String dsNome) {

        return abstractMapper.toDomain(db.findByNome(dsNome));
    }
}

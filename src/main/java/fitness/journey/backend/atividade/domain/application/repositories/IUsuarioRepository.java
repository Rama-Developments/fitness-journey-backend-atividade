package fitness.journey.backend.atividade.domain.application.repositories;

import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.shared.repositories.IRepository;

public interface IUsuarioRepository extends IRepository<Usuario> {

    Usuario findByEmail(String dsEmail);
}

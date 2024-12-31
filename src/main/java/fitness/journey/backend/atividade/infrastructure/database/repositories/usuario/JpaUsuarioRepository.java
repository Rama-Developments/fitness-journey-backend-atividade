package fitness.journey.backend.atividade.infrastructure.database.repositories.usuario;

import fitness.journey.backend.atividade.infrastructure.database.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(value = """
        select
            a
        from UsuarioEntity a
        where a.dsNome = ?1
    """)
    UsuarioEntity findByNome(String nome);
}

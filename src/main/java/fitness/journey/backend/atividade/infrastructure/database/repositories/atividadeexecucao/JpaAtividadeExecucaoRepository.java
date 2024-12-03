package fitness.journey.backend.atividade.infrastructure.database.repositories.atividadeexecucao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeExecucaoEntity;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Repository
public interface JpaAtividadeExecucaoRepository extends JpaRepository<AtividadeExecucaoEntity, Long> {

    @Query(value = "select ae from AtividadeExecucaoEntity ae where ae.atividade.idAtividade = ?1")
    AtividadeExecucaoEntity findByidAtividade(Long idAtividade);
}

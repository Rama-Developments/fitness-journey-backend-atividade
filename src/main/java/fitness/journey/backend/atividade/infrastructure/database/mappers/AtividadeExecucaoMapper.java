package fitness.journey.backend.atividade.infrastructure.database.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.AtividadeExecucao;
import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeEntity;
import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeExecucaoEntity;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.mapper.AbstractMapper;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Mapper
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtividadeExecucaoMapper implements AbstractMapper<AtividadeExecucao, AtividadeExecucaoEntity> {

    @Override
    public AtividadeExecucao toDomain(AtividadeExecucaoEntity entity) {

        var domain = new AtividadeExecucao();

        domain.setIdAtividade(UniqueEntityId.createFromData(entity.getAtividade().getIdAtividade()));
        domain.setId(UniqueEntityId.createFromData(entity.getIdAtividadeExecucao()));
        domain.setDsAtividade(entity.getDsAtividade());

        domain.setDhInicio(entity.getDhInicio());
        domain.setDhFim(entity.getDhFim());

        return domain;
    }

    @Override
    public AtividadeExecucaoEntity toDb(AtividadeExecucao domain) {

        var entity = new AtividadeExecucaoEntity();

        entity.setAtividade(new AtividadeEntity());
        entity.setDsAtividade(domain.getDsAtividade());
        entity.getAtividade().setIdAtividade(domain.getIdAtividade().getAsNumber());
        entity.setDhInicio(domain.getDhInicio());
        entity.setDhFim(domain.getDhFim());

        return entity;
    }
}

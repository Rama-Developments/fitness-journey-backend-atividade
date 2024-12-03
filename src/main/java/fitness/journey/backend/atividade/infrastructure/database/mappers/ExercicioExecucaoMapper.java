package fitness.journey.backend.atividade.infrastructure.database.mappers;

import static java.util.Objects.nonNull;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeExecucaoEntity;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioEntity;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioExecucaoEntity;
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
public class ExercicioExecucaoMapper implements AbstractMapper<ExercicioExecucao, ExercicioExecucaoEntity> {

    @Override
    public ExercicioExecucao toDomain(ExercicioExecucaoEntity entity) {

        var domain = new ExercicioExecucao();

        domain.setId(UniqueEntityId.createFromData(entity.getIdExercicioExecucao()));
        domain.setDsExercicio(entity.getDsExercicio());
        domain.setIdExercicio(UniqueEntityId.createFromData(entity.getExercicio().getIdExercicio()));
        if (nonNull(entity.getAtividade())) {
            domain.setIdAtividadeExecucao(UniqueEntityId.createFromData(entity.getAtividade().getIdAtividadeExecucao()));
        }
        domain.setVlCarga(entity.getVlCarga());
        domain.setQtRepeticao(entity.getQtRepeticao());

        return domain;
    }

    @Override
    public ExercicioExecucaoEntity toDb(ExercicioExecucao domain) {

        var entity = new ExercicioExecucaoEntity();

        entity.setExercicio(new ExercicioEntity());
        entity.setDsExercicio(domain.getDsExercicio());
        entity.getExercicio().setIdExercicio(domain.getIdExercicio().getAsNumber());
        entity.setVlCarga(domain.getVlCarga());
        entity.setQtRepeticao(domain.getQtRepeticao());
        entity.setAtividade(new AtividadeExecucaoEntity());
        entity.getAtividade().setIdAtividadeExecucao(domain.getIdAtividadeExecucao().getAsNumber());

        return entity;
    }
}

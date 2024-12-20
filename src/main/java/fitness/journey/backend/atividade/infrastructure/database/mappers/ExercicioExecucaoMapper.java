package fitness.journey.backend.atividade.infrastructure.database.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.ExercicioExecucao;
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
        domain.setIdExercicio(UniqueEntityId.createFromData(entity.getExercicio().getIdExercicio()));
        domain.setVlCarga(entity.getVlCarga());
        domain.setQtRepeticao(entity.getQtRepeticao());
        domain.setDhExecucao(entity.getDhExecucao());
        domain.setNrSequencia(entity.getNrSequencia());

        return domain;
    }

    @Override
    public ExercicioExecucaoEntity toDb(ExercicioExecucao domain) {

        var entity = new ExercicioExecucaoEntity();

        entity.setExercicio(new ExercicioEntity());
        entity.getExercicio().setIdExercicio(domain.getIdExercicio().getAsNumber());
        entity.setVlCarga(domain.getVlCarga());
        entity.setQtRepeticao(domain.getQtRepeticao());
        entity.setDhExecucao(domain.getDhExecucao());
        entity.setNrSequencia(domain.getNrSequencia());

        return entity;
    }
}

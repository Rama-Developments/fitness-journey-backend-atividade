package fitness.journey.backend.atividade.infrastructure.database.mappers;

import static java.util.Objects.isNull;

import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioEntity;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.mapper.AbstractMapper;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@Mapper
public class ExercicioMapper implements AbstractMapper<Exercicio, ExercicioEntity> {

    @Override
    public Exercicio toDomain(ExercicioEntity raw) {

        if (isNull(raw)) {
            return null;
        }

        var domain = new Exercicio();

        domain.setDsExercicio(raw.getDsExercicio());
        domain.setId(UniqueEntityId.createFromData(raw.getIdExercicio()));


        return domain;
    }

    @Override
    public ExercicioEntity toDb(Exercicio domain) {

        var entity = new ExercicioEntity();

        entity.setIdExercicio(domain.getId().getAsNumber());
        entity.setDsExercicio(domain.getDsExercicio());


        return entity;
    }
}

package fitness.journey.backend.atividade.infrastructure.database.mappers;

import static java.util.Objects.isNull;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.database.entities.AtividadeEntity;
import fitness.journey.backend.atividade.infrastructure.database.entities.ExercicioEntity;
import fitness.journey.backend.atividade.shared.annotations.Mapper;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;
import fitness.journey.backend.atividade.shared.mapper.AbstractMapper;
import lombok.AllArgsConstructor;

/**
 * @author stevenreis
 * @since 1.0 (16/11/24)
 */
@Mapper
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtividadeMapper implements AbstractMapper<Atividade, AtividadeEntity> {

    private final AbstractMapper<Exercicio, ExercicioEntity> exercicioMapper;

    @Override
    public Atividade toDomain(AtividadeEntity dbEntity) {

        if (isNull(dbEntity)) {
            return null;
        }

        var atividade = new Atividade();

        atividade.setId(UniqueEntityId.createFromData(dbEntity.getIdAtividade()));
        atividade.setDsAtividade(dbEntity.getDsAtividade());
        atividade.setDhCriacao(dbEntity.getDhInclusao());
        atividade.setDhAlteracao(dbEntity.getDhAlteracao());

        atividade.setExercicios(dbEntity.getExercicios().stream().map(exercicioMapper::toDomain).collect(Collectors.toList()));

        return atividade;
    }

    @Override
    public AtividadeEntity toDb(Atividade atividade) {

        AtividadeEntity entity = new AtividadeEntity();

        entity.setDsAtividade(atividade.getDsAtividade());
        entity.setIdAtividade(atividade.getId().getAsNumber());
        entity.setDhInclusao(atividade.getDhCriacao());
        entity.setDhAlteracao(atividade.getDhAlteracao());
        entity.setExercicios(atividade.getExercicios().stream().map(exercicioMapper::toDb).toList());

        return entity;
    }
}

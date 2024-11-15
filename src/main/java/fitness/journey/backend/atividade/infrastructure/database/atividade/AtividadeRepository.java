package fitness.journey.backend.atividade.infrastructure.database.atividade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fitness.journey.backend.atividade.domain.application.repositories.IAtividadeRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.shared.entities.UniqueEntityId;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
@Component
public class AtividadeRepository implements IAtividadeRepository {

    private List<Atividade> atividades = new ArrayList<>();

    @Override
    public List<Atividade> fetch() {

        return atividades;
    }

    @Override
    public Atividade findById(UniqueEntityId id) {

        return null;
    }

    @Override
    public Atividade create(Atividade entity) {

        atividades.add(entity);

        return entity;
    }
}

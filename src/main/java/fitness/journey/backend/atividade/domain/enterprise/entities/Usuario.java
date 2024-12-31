package fitness.journey.backend.atividade.domain.enterprise.entities;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends AbstractEntity {

    private String dsNome;

    private String dsSenha;

    private String dsEmail;
}

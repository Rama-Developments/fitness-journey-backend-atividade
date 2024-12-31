package fitness.journey.backend.atividade.infrastructure.http.presenters;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioPresenter {

    private Long idUsuario;

    private String dsNome;

    private String dsEmail;
}

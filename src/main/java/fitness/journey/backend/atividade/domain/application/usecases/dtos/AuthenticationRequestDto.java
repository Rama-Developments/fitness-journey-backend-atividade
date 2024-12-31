package fitness.journey.backend.atividade.domain.application.usecases.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDto {

    private String dsEmail;

    private String dsSenha;
}

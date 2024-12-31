package fitness.journey.backend.atividade.domain.application.usecases.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioRequestDto {

    @NotBlank
    private String dsNome;

    @NotBlank
    private String dsSenha;

    @NotBlank
    private String dsEmail;
}

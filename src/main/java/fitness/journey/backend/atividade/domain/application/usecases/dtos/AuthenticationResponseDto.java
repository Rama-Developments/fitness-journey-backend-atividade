package fitness.journey.backend.atividade.domain.application.usecases.dtos;

import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;

public record AuthenticationResponseDto(Usuario usuario, String accessToken) {
}

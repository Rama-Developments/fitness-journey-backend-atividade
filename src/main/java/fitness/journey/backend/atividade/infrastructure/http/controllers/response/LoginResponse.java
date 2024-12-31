package fitness.journey.backend.atividade.infrastructure.http.controllers.response;

import fitness.journey.backend.atividade.infrastructure.http.presenters.UsuarioPresenter;

public record LoginResponse(UsuarioPresenter data, String accessToken) {
}

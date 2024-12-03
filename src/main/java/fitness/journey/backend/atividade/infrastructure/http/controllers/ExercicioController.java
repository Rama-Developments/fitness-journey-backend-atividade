package fitness.journey.backend.atividade.infrastructure.http.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import fitness.journey.backend.atividade.infrastructure.http.presenters.ExercicioPresenter;
import fitness.journey.backend.atividade.shared.http.controllers.AbstractController;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@RestController
@RequestMapping("exercicio")
public class ExercicioController extends AbstractController<Exercicio, ExercicioPresenter> {

}

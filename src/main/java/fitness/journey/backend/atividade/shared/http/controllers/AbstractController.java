package fitness.journey.backend.atividade.shared.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.usecases.AbstractCreateUseCase;
import fitness.journey.backend.atividade.shared.usecases.AbstractFetchUseCase;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
@RestController
public class AbstractController<T extends AbstractEntity> {

    @Autowired(required = false)
    protected AbstractFetchUseCase<T> fetchUseCase;

    @Autowired(required = false)
    protected AbstractCreateUseCase<T> createUseCase;

    @GetMapping
    public ResponseEntity findAll() {

        try {
            var items = fetchUseCase.execute();

            return ResponseEntity.ok(items);
        } catch (Exception ex) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody T entity) {

        try {
            var item = createUseCase.execute(entity);

            return ResponseEntity.ok(item);
        } catch (Exception ex) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

package fitness.journey.backend.atividade.shared.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.i18n.I18nService;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;
import fitness.journey.backend.atividade.shared.usecases.AbstractCreateUseCase;
import fitness.journey.backend.atividade.shared.usecases.AbstractFetchUseCase;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
public class AbstractController<T extends AbstractEntity, P> {

    @Autowired(required = false)
    protected AbstractFetchUseCase<T> fetchUseCase;

    @Autowired(required = false)
    protected AbstractCreateUseCase<T> createUseCase;

    @Autowired(required = false)
    protected I18nService i18nService;

    @Autowired(required = false)
    protected HttpMapper<T, P> httpMapper;

    @GetMapping
    public ResponseEntity findAll() {

        return ok(httpMapper.mapList(fetchUseCase.execute()));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody T entity) {

        try {

            return created(httpMapper.map(createUseCase.execute(entity)));
        } catch (Exception ex) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    protected DefaultResponseEntity created(Object data) {

        return new DefaultResponseEntity(data, i("criado.com.sucesso"));
    }

    protected DefaultResponseEntity ok(Object data) {

        return new DefaultResponseEntity(data);
    }

    protected DefaultResponseEntity ok(T data) {

        return new DefaultResponseEntity(httpMapper.map(data));
    }

    protected DefaultResponseEntity ok(List<T> data) {

        return new DefaultResponseEntity(httpMapper.mapList(data));
    }

    protected ResponseEntity noContent() {

        return ResponseEntity.noContent().build();
    }

    protected String i(String message) {

        return this.i18nService.i(message);
    }
}

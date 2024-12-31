package fitness.journey.backend.atividade.infrastructure.http.controllers;

import static java.util.Objects.nonNull;

import java.util.List;

import fitness.journey.backend.atividade.infrastructure.http.controllers.response.DefaultResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import fitness.journey.backend.atividade.shared.i18n.I18nService;
import fitness.journey.backend.atividade.shared.mapper.HttpMapper;
import fitness.journey.backend.atividade.shared.usecases.AbstractCreateUseCase;
import fitness.journey.backend.atividade.shared.usecases.AbstractFetchUseCase;
import fitness.journey.backend.atividade.shared.usecases.AbstractFindOneUseCase;

/**
 * @author stevenreis
 * @since 1.0 (15/11/24)
 */
public class AbstractController<T extends AbstractEntity, P> {

    @Autowired(required = false)
    protected AbstractFetchUseCase<T> fetchUseCase;

    @Autowired(required = false)
    protected AbstractFindOneUseCase<T> findOneUseCase;

    @Autowired(required = false)
    protected AbstractCreateUseCase<T> createUseCase;

    @Autowired(required = false)
    protected I18nService i18nService;

    @Autowired(required = false)
    protected HttpMapper<T, P> httpMapper;

    @GetMapping
    public ResponseEntity findAll() {

        return ok(httpMapper.mapList(fetchUseCase.execute(null)));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        T domainEntity = findOneUseCase.execute(id);

        return nonNull(domainEntity) ? ok(httpMapper.map(domainEntity)) : noContent();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody T entity) {

        return created(httpMapper.map(createUseCase.execute(entity)));
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

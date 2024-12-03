package fitness.journey.backend.atividade.shared.http.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author stevenreis
 * @since 1.0 (22/11/24)
 */
public class DefaultResponseEntity extends ResponseEntity<Object> {

    public Object data;

    public String message;

    public DefaultResponseEntity(Object data) {

        super(Map.of("data", data), HttpStatus.OK);

    }

    public DefaultResponseEntity(Object data, HttpStatus status) {
        super(status);
        this.data = data;
    }

    public DefaultResponseEntity(Object data, String message) {
        super(HttpStatus.CREATED);
        this.data = data;
        this.message = message;
    }
}

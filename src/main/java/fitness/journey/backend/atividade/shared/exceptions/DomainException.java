package fitness.journey.backend.atividade.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author stevenreis
 * @since 1.0 (16/11/24)
 */
@Slf4j
@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DomainException extends RuntimeException {

    private String message;

    public DomainException(String message) {

        this.message = message;

        log.error(message);
    }
}

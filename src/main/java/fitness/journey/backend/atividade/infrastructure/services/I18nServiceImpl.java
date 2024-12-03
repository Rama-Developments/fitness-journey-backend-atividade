package fitness.journey.backend.atividade.infrastructure.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import fitness.journey.backend.atividade.shared.i18n.I18nService;

/**
 * @author stevenreis
 * @since 1.0 (22/11/24)
 */
@Service
public class I18nServiceImpl implements I18nService {

    @Value("${fitness.journey.backend.i18n.url}")
    private String i18nUrl;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public String i(String message) {

        try {
            var httpRequest = HttpRequest.newBuilder(getUri(message))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());

            return response.statusCode() != HttpStatus.OK.value() ? message : response.body();

        } catch (Exception ex) {

            return message;
        }
    }

    @Override
    public String i(String message, Object... args) {

        return String.format(i(message), args);
    }

    private URI getUri(String message) {

        return UriComponentsBuilder.fromUriString(i18nUrl)
                .queryParam("project", "backend")
                .queryParam("language", "pt-br")
                .queryParam("property", message)
                .build()
                .toUri();
    }
}

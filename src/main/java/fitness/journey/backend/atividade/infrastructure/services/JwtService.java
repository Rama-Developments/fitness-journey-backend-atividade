package fitness.journey.backend.atividade.infrastructure.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.shared.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    private String jwtSecret = "my-secret";

    private final Algorithm ALGORITHM = Algorithm.HMAC256(jwtSecret);

    private final String ISSUER = "jwt-service";

    public String generateToken(Usuario usuario) {

        try {

            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuario.getDsEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(ALGORITHM);

        } catch (Exception e) {

            throw new DomainException("erro.gerar.jwt");
        }
    }

    public String validate(String token) {

        try {
            return JWT.require(ALGORITHM)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {

            return "";
        }
    }

    private Instant generateExpirationDate() {

        return LocalDateTime.now()
                .plusHours(4)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}

package fitness.journey.backend.atividade.infrastructure.security;

import fitness.journey.backend.atividade.domain.application.repositories.IUsuarioRepository;
import fitness.journey.backend.atividade.domain.enterprise.entities.Usuario;
import fitness.journey.backend.atividade.infrastructure.services.JwtService;
import fitness.journey.backend.atividade.infrastructure.session.UsuarioSessionContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityFilter extends OncePerRequestFilter {

    private final @NonNull IUsuarioRepository usuarioRepository;

    private final @NonNull JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token = this.recoverToken(request);

        if (token != null) {

            var email = jwtService.validate(token);

            Usuario usuario = usuarioRepository.findByEmail(email);

            UsuarioSessionContextHolder.context.put("idusuario", usuario.getId().getAsNumber());

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest req) {

        String authHeader = req.getHeader("Authorization");

        return authHeader == null ? null : authHeader.replace("Bearer ", "");
    }
}

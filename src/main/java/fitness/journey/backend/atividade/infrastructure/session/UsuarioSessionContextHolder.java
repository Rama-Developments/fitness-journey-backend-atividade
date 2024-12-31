package fitness.journey.backend.atividade.infrastructure.session;

import fitness.journey.backend.atividade.shared.exceptions.DomainException;

import java.util.HashMap;
import java.util.Map;

public class UsuarioSessionContextHolder {

    public static Map<String, Object> context = new HashMap<>();

    public static Long getIdUsuarioLogado() {

        if (context.get("idusuario") == null) {
            throw new DomainException("usuario.logado.nao.encontrado");
        }

        return Long.parseLong(context.get("idusuario").toString());
    }
}

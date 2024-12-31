package fitness.journey.backend.atividade.domain.enterprise.entities;

import fitness.journey.backend.atividade.shared.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends AbstractEntity implements UserDetails {

    private String dsNome;

    private String dsSenha;

    private String dsEmail;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.dsSenha;
    }

    @Override
    public String getUsername() {
        return this.dsEmail;
    }
}

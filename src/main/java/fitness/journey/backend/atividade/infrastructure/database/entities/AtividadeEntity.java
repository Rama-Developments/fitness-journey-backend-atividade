package fitness.journey.backend.atividade.infrastructure.database.entities;

import java.time.LocalDateTime;
import java.util.List;

import fitness.journey.backend.atividade.domain.enterprise.entities.Atividade;
import fitness.journey.backend.atividade.domain.enterprise.entities.Exercicio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (16/11/24)
 */
@Entity
@Getter
@Setter
@Table(name = "atividade")
public class AtividadeEntity {

    @Id
    @Column(name = "id_atividade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtividade;

    private String dsAtividade;

    private LocalDateTime dhInclusao;

    private LocalDateTime dhAlteracao;

    @ManyToMany
    @JoinTable(
            name = "atividade_exercicio"
    )
    private List<ExercicioEntity> exercicios;
}

package fitness.journey.backend.atividade.infrastructure.database.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (03/12/24)
 */
@Getter
@Setter
@Entity
@Table(name = "atividade_execucao")
public class AtividadeExecucaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtividadeExecucao;

    @ManyToOne
    @JoinColumn(name = "id_atividade")
    private AtividadeEntity atividade;

    private String dsAtividade;

    private LocalDateTime dhInicio;

    private LocalDateTime dhFim;

    @OneToMany
    private List<ExercicioExecucaoEntity> exercicios;
}

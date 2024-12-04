package fitness.journey.backend.atividade.infrastructure.database.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "exercicio_execucao")
public class ExercicioExecucaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercicioExecucao;

    @ManyToOne
    @JoinColumn(name = "id_exercicio", nullable = false)
    private ExercicioEntity exercicio;

    @ManyToOne
    @JoinColumn(name = "id_atividade_execucao", nullable = false)
    private AtividadeExecucaoEntity atividade;

    private String dsExercicio;

    private Integer nrSequencia;

    private BigDecimal vlCarga;

    private Integer qtRepeticao;
}
package fitness.journey.backend.atividade.infrastructure.database.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author stevenreis
 * @since 1.0 (26/11/24)
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercicio")
public class ExercicioEntity {

    @Id
    @Column(name = "id_exercicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercicio;

    private String dsExercicio;

    private LocalDateTime dhInclusao;

    private LocalDateTime dhAlteracao;

    @ManyToMany(mappedBy = "exercicios")
    private List<AtividadeEntity> atividades;
}

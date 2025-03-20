package fr.maif.tirperf.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "contextexecution")
public class ContextExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String environnement;

    @Column(columnDefinition = "jsonb")
    private String infoComplementaires;
}

package fr.maif.tirperf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rapportexecution")
public class RapportExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "jsonb")
    private String tempsAppels;
    private Integer nbApeel;
    private Integer tauxSuccessKo;

    @ElementCollection
    private List<String> erruers;

    private Integer minDuration;
    private Integer maxDuration;
    private Integer avgDuration;
    private Integer medianDuration;
}

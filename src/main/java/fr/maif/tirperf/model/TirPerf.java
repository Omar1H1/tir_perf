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
@Table(name = "tirperf")
public class TirPerf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private java.sql.Timestamp tirperfDate;

    @ManyToOne
    @JoinColumn(name = "rapport_id")
    private RapportExecution rapport;

    @ManyToOne
    @JoinColumn(name = "context_id")
    private ContextExecution context;

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;
}

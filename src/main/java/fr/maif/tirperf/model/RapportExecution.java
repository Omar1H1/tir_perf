package fr.maif.tirperf.model;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import io.hypersistence.utils.hibernate.type.json.JsonType; // Correct import
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
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

    @Type(JsonBinaryType.class)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String tempsAppels;

    private Integer nbApeel;
    private Integer tauxSuccessKo;

    @ElementCollection
    private List<String> erruers = new ArrayList<>();

    private Integer minDuration;
    private Integer maxDuration;
    private Integer avgDuration;
    private Integer medianDuration;
}
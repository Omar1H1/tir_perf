package fr.maif.tirperf.serviceTest.Integration;

import fr.maif.tirperf.model.*;
import fr.maif.tirperf.service.*;
import fr.maif.tirperf.utils.JsonValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TirPerfServiceIntegrationTest {

    @Autowired
    private TirPerfService tirPerfService;

    @Autowired
    private ApplicatifService applicatifService;

    @Autowired
    private ContextExecutionService contextExecutionService;

    @Autowired
    private ScenarioService scenarioService;

    @Autowired
    private RapportExecutionService rapportExecutionService;

    TirPerf tirPerf;
    Applicatif applicatif;
    ContextExecution contextExecution;
    Scenario scenario;
    RapportExecution rapportExecution;

    @BeforeEach
    void setup () {

        applicatif = Applicatif.builder()
                .intitule("MR")
                .build();

        contextExecution = ContextExecution.builder()
                .environnement("perf")
                .infoComplementaires("{\"system\":\"Linux\",\"ram\":\"16g\"}")
                .build();

        scenario = Scenario.builder()
                .reference("test 1")
                .description("test avec 2000 case")
                .tags(Set.of("mock"))
                .build();

        rapportExecution =RapportExecution.builder()
                .tempsAppels("{\"apiCall\":\"GET /users\",\"responseTime\":\"200ms\"}")
                .nbApeel(15)
                .tauxSuccessKo(3)
                .erruers(Arrays.asList("Timeout error", "Invalid response format"))
                .minDuration(150)
                .maxDuration(600)
                .avgDuration(350)
                .medianDuration(300)
                .build();

        tirPerf = TirPerf.builder()
                .reference("tirperf mr")
                .applicatif(applicatif)
                .context(contextExecution)
                .scenario(scenario)
                .rapport(rapportExecution)
                .build();


        applicatifService.saveApplicatif(applicatif);
        contextExecutionService.saveContextExecution(contextExecution);
        scenarioService.saveScenario(scenario);
        rapportExecutionService.saveRapportExecution(rapportExecution);
        tirPerfService.saveTirPerf(tirPerf);
    }

    @Test
    void testSaveAndRetrieveTirPerf () {
        TirPerf foundTirPerf = tirPerfService.getTirPerfById(tirPerf.getId());

        assertThat(foundTirPerf).isNotNull();
        assertThat(foundTirPerf.getApplicatif()).isEqualTo(applicatif);
        assertThat(foundTirPerf.getContext()).isEqualTo(contextExecution);
        assertThat(foundTirPerf.getScenario()).isEqualTo(scenario);
        assertThat(JsonValidator.isValid(tirPerf.getContext().getInfoComplementaires())).isTrue();
        assertThat(JsonValidator.isValid(tirPerf.getRapport().getTempsAppels())).isTrue();
    }
}

package fr.maif.tirperf.serviceTest.Integration;

import fr.maif.tirperf.model.Scenario;
import fr.maif.tirperf.repository.ScenarioRepository;
import fr.maif.tirperf.service.ScenarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ScenarioServiceIntegrationTest {

    @Autowired
    private ScenarioService scenarioService;

    @Autowired
    private ScenarioRepository scenarioRepository;

    private Scenario scenario;

    @BeforeEach
    void setUp() {
        scenario = new Scenario();
        scenario.setReference("test 1");
        scenario.setDescription("Integration Test Scenario");
        scenario.setTags(Set.of("integration", "test"));
        scenarioService.saveScenario(scenario);
    }

    @Test
    void testSaveAndRetrieveScenario() {
        Scenario foundScenario = scenarioService.getScenarioById(scenario.getId());

        assertThat(foundScenario).isNotNull();
        assertThat(foundScenario.getDescription()).isEqualTo("Integration Test Scenario");
    }

    @Test
    void testUpdateScenario() {
        scenario.setDescription("Updated Scenario");
        scenario.setTags(new HashSet<>(Set.of("updated", "test")));
        scenarioService.updateScenario(scenario);

        Scenario updatedScenario = scenarioService.getScenarioById(scenario.getId());
        assertThat(updatedScenario.getDescription()).isEqualTo("Updated Scenario");
        assertThat(updatedScenario.getTags()).containsExactlyInAnyOrder("updated", "test");
    }

    @Test
    void testDeleteScenario() {
        scenarioService.deleteScenario(scenario.getId());
        Scenario deletedScenario = scenarioService.getScenarioById(scenario.getId());

        assertThat(deletedScenario).isNull();
    }

    @Test
    void testGetAllScenarios() {
        List<Scenario> scenarios = scenarioService.getAllScenarios();

        assertThat(scenarios).isNotEmpty();
    }

    @Test
    void testGetScenarioByReference() {
        Scenario foundScenario = scenarioService.getScenarioByReference("test 1");

        assertThat(foundScenario).isNotNull();
        assertThat(foundScenario.getReference()).isEqualTo("test 1");
    }
}
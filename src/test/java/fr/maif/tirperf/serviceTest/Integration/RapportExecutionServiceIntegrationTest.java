package fr.maif.tirperf.serviceTest.Integration;

import fr.maif.tirperf.model.RapportExecution;
import fr.maif.tirperf.service.RapportExecutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class RapportExecutionServiceIntegrationTest {

    @Autowired
    private RapportExecutionService rapportExecutionService;

    private RapportExecution rapportExecution;

    @BeforeEach
    void setUp() {
        rapportExecution = new RapportExecution();
        rapportExecution.setTempsAppels("{\"apiCall\":\"GET /users\",\"responseTime\":\"200ms\"}");
        rapportExecution.setNbApeel(15);
        rapportExecution.setTauxSuccessKo(3);
        rapportExecution.setErruers(new ArrayList<>(Arrays.asList("Timeout error", "Invalid response format")));
        rapportExecution.setMinDuration(150);
        rapportExecution.setMaxDuration(600);
        rapportExecution.setAvgDuration(350);
        rapportExecution.setMedianDuration(300);
        rapportExecutionService.saveRapportExecution(rapportExecution);
    }

    @Test
    void testSaveAndRetrieveRapportExecution() {
        RapportExecution foundRapportExecution = rapportExecutionService.getRapportExecutionById(rapportExecution.getId());

        assertThat(foundRapportExecution).isNotNull();
        assertThat(foundRapportExecution.getTempsAppels()).isEqualTo("{\"apiCall\":\"GET /users\",\"responseTime\":\"200ms\"}");
        assertThat(foundRapportExecution.getNbApeel()).isEqualTo(15);
    }

    @Test
    void testUpdateRapportExecution() {
        rapportExecution.setNbApeel(20);
        rapportExecutionService.updateRapportExecution(rapportExecution);

        RapportExecution updatedRapportExecution = rapportExecutionService.getRapportExecutionById(rapportExecution.getId());
        assertThat(updatedRapportExecution.getNbApeel()).isEqualTo(20);
    }

    @Test
    void testDeleteRapportExecution() {
        rapportExecutionService.deleteRapportExecution(rapportExecution.getId());
        RapportExecution deletedRapportExecution = rapportExecutionService.getRapportExecutionById(rapportExecution.getId());

        assertThat(deletedRapportExecution).isNull();
    }

    @Test
    void testGetAllRapportExecutions() {
        List<RapportExecution> rapportExecutions = rapportExecutionService.getAllRapportExecutions();

        assertThat(rapportExecutions).isNotEmpty();
    }
}
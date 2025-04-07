package fr.maif.tirperf.serviceTest.Integration;

import fr.maif.tirperf.model.ContextExecution;
import fr.maif.tirperf.service.ContextExecutionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ContextExecutionIntegrationTest {


    @Autowired
    private ContextExecutionService contextExecutionService;

    private ContextExecution contextExecution;

    @BeforeEach
    void setup () {
        contextExecution = new ContextExecution();
        contextExecution.setEnvironnement("perf");
        contextExecution.setInfoComplementaires("{\"system\":\"Linux\",\"ram\":\"16g\"}");

        contextExecutionService.saveContextExecution(contextExecution);
    }

    @Test
    void testSaveAndRetrieveContextExecution () {
        ContextExecution foundContextExecution = contextExecutionService.getContextExecutionById(contextExecution.getId());

        assertThat(foundContextExecution).isNotNull();
        assertThat(foundContextExecution.getEnvironnement()).isEqualTo("perf");
        assertThat(foundContextExecution.getInfoComplementaires()).isEqualTo("{\"system\":\"Linux\",\"ram\":\"16g\"}");
    }

    @Test
    void testUpdateContextExecution () {
       contextExecution.setEnvironnement("TDV2");

       ContextExecution updateContextExecution = contextExecutionService.updateContextExecution(contextExecution);

       assertThat(updateContextExecution.getEnvironnement()).isEqualTo("TDV2");
    }

    @Test
    void testDeleteContextExecution () {
        contextExecutionService.deleteContextExecution(contextExecution.getId());

        ContextExecution deletedContextExecution = contextExecutionService.getContextExecutionById(contextExecution.getId());

        assertThat(deletedContextExecution).isNull();
    }

    @Test
    void testGetAllContextExecution () {
        List<ContextExecution> contextExecutions = contextExecutionService.getAllContextExecutions();

        assertThat(contextExecutions).isNotEmpty();
    }

}

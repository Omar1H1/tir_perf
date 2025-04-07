package fr.maif.tirperf.serviceTest.Mock;

import fr.maif.tirperf.model.Scenario;
import fr.maif.tirperf.repository.ScenarioRepository;
import fr.maif.tirperf.service.ScenarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ScenarioServiceMockTest {

    @Mock
    private ScenarioRepository scenarioRepository;

    @InjectMocks
    private ScenarioService scenarioService;

    private Scenario scenario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        scenario = new Scenario();
        scenario.setId(1L);
        scenario.setDescription("Test Scenario");
        scenario.setTags(Set.of("mock"));
        scenario.setReference("test 1");
    }

    @Test
    void testSaveScenario() {
        when(scenarioRepository.save(any(Scenario.class))).thenReturn(scenario);

        Scenario savedScenario = scenarioService.saveScenario(scenario);

        assertNotNull(savedScenario);
        assertEquals("Test Scenario", savedScenario.getDescription());
        verify(scenarioRepository, times(1)).save(scenario);
    }

    @Test
    void testGetScenarioById() {
        when(scenarioRepository.findById(1L)).thenReturn(Optional.of(scenario));

        Scenario foundScenario = scenarioService.getScenarioById(1L);

        assertNotNull(foundScenario);
        assertEquals("Test Scenario", foundScenario.getDescription());
        verify(scenarioRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllScenarios() {
        when(scenarioRepository.findAll()).thenReturn(List.of(scenario));

        Iterable<Scenario> scenarios = scenarioService.getAllScenarios();

        assertNotNull(scenarios);
        assertTrue(scenarios.iterator().hasNext());
        verify(scenarioRepository, times(1)).findAll();
    }

    @Test
    void testUpdateScenario() {
        when(scenarioRepository.save(any(Scenario.class))).thenReturn(scenario);

        Scenario updatedScenario = scenarioService.updateScenario(scenario);

        assertNotNull(updatedScenario);
        assertEquals("Test Scenario", updatedScenario.getDescription());
        verify(scenarioRepository, times(1)).save(scenario);
    }

    @Test
    void testDeleteScenario() {
        scenarioService.deleteScenario(scenario.getId());
        verify(scenarioRepository, times(1)).deleteById(scenario.getId());
    }

    @Test
    void testGetScenarioByReference() {
        when(scenarioRepository.findByReference("test 1")).thenReturn(Optional.of(scenario));

        Scenario foundScenario = scenarioService.getScenarioByReference("test 1");

        assertNotNull(foundScenario);
        assertEquals("Test Scenario", foundScenario.getDescription());
        verify(scenarioRepository, times(1)).findByReference("test 1");
    }
}
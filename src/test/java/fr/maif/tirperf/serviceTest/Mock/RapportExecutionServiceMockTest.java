package fr.maif.tirperf.serviceTest.Mock;

import fr.maif.tirperf.model.RapportExecution;
import fr.maif.tirperf.repository.RapportExecutionRepository;
import fr.maif.tirperf.service.RapportExecutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RapportExecutionServiceMockTest {

    @Mock
    private RapportExecutionRepository rapportExecutionRepository;

    @InjectMocks
    private RapportExecutionService rapportExecutionService;

    private RapportExecution rapportExecution;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        rapportExecution = RapportExecution.builder()
                .id(1L)
                .tempsAppels("{\"apiCall\":\"GET /users\",\"responseTime\":\"200ms\"}")
                .nbApeel(15)
                .tauxSuccessKo(3)
                .erruers(Arrays.asList("Timeout error", "Invalid response format"))
                .minDuration(150)
                .maxDuration(600)
                .avgDuration(350)
                .medianDuration(300)
                .build();
    }

    @Test
    void testSaveRapportExecution() {
        when(rapportExecutionRepository.save(any(RapportExecution.class))).thenReturn(rapportExecution);

        RapportExecution savedRapportExecution = rapportExecutionService.saveRapportExecution(rapportExecution);

        assertNotNull(savedRapportExecution);
        assertEquals(rapportExecution.getId(), savedRapportExecution.getId());
        verify(rapportExecutionRepository, times(1)).save(rapportExecution);
    }

    @Test
    void testGetRapportExecutionById() {
        when(rapportExecutionRepository.findById(1L)).thenReturn(Optional.of(rapportExecution));

        RapportExecution foundRapportExecution = rapportExecutionService.getRapportExecutionById(1L);

        assertNotNull(foundRapportExecution);
        assertEquals(rapportExecution.getId(), foundRapportExecution.getId());
        verify(rapportExecutionRepository, times(1)).findById(1L);
    }

    @Test
    void testGetRapportExecutionById_NotFound() {
        when(rapportExecutionRepository.findById(1L)).thenReturn(Optional.empty());

        RapportExecution foundRapportExecution = rapportExecutionService.getRapportExecutionById(1L);

        assertNull(foundRapportExecution);
        verify(rapportExecutionRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteRapportExecution() {
        doNothing().when(rapportExecutionRepository).delete(any(RapportExecution.class));

        rapportExecutionService.deleteRapportExecution(rapportExecution.getId());

        verify(rapportExecutionRepository, times(1)).deleteById(rapportExecution.getId());
    }

    @Test
    void testUpdateRapportExecution() {
        when(rapportExecutionRepository.save(any(RapportExecution.class))).thenReturn(rapportExecution);

        RapportExecution updatedRapportExecution = rapportExecutionService.updateRapportExecution(rapportExecution);

        assertNotNull(updatedRapportExecution);
        assertEquals(rapportExecution.getId(), updatedRapportExecution.getId());
        verify(rapportExecutionRepository, times(1)).save(rapportExecution);
    }

    @Test
    void testGetAllRapportExecutions() {
        when(rapportExecutionRepository.findAll()).thenReturn(Collections.singletonList(rapportExecution));

        Iterable<RapportExecution> rapportExecutions = rapportExecutionService.getAllRapportExecutions();

        assertNotNull(rapportExecutions);
        assertTrue(rapportExecutions.iterator().hasNext());
        verify(rapportExecutionRepository, times(1)).findAll();
    }
}
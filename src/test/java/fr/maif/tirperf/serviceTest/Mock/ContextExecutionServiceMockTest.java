package fr.maif.tirperf.serviceTest.Mock;

import fr.maif.tirperf.model.ContextExecution;
import fr.maif.tirperf.repository.ContextExecutionRepository;
import fr.maif.tirperf.service.ContextExecutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ContextExecutionServiceMockTest {

    @Mock
    private ContextExecutionRepository contextExecutionRepository;

    @InjectMocks
    private ContextExecutionService contextExecutionService;

    private ContextExecution contextExecution;

    @BeforeEach
    void setup () {
        MockitoAnnotations.openMocks(this);
        contextExecution = new ContextExecution();
        contextExecution.setId(1L);
        contextExecution.setEnvironnement("perf");
        contextExecution.setInfoComplementaires("{\"system\":\"Linux\",\"ram\":\"16g\"}");
    }

    @Test
    void testSaveContextExecution () {
        when(contextExecutionRepository.save(any(ContextExecution.class))).thenReturn(contextExecution);

        ContextExecution savedContextExecution = contextExecutionService.saveContextExecution(contextExecution);

        assertNotNull(savedContextExecution);
        assertEquals(contextExecution.getId(), savedContextExecution.getId());
        assertEquals(contextExecution.getInfoComplementaires(), savedContextExecution.getInfoComplementaires());
        verify(contextExecutionRepository, times(1)).save(contextExecution);
    }

    @Test
    void testGetContextExecutionById () {
        when(contextExecutionRepository.findById(1L)).thenReturn(Optional.of(contextExecution));

        ContextExecution foundContextExecution = contextExecutionService.getContextExecutionById(1L);

        assertNotNull(foundContextExecution);
        assertEquals(contextExecution.getId(), foundContextExecution.getId());
        verify(contextExecutionRepository, times(1)).findById(1L);
    }


    @Test
    void testGetContextExecutionById_NotFound() {
        when(contextExecutionRepository.findById(2L)).thenReturn(Optional.empty());

        ContextExecution foundRapportExecution = contextExecutionService.getContextExecutionById(2L);

        assertNull(foundRapportExecution);
        verify(contextExecutionRepository, times(1)).findById(2L);
    }

    @Test
    void testDeleteContextExecutionById () {
        doNothing().when(contextExecutionRepository).delete(any(ContextExecution.class));

        contextExecutionService.deleteContextExecution(contextExecution.getId());

        verify(contextExecutionRepository, times(1)).deleteById(contextExecution.getId());
    }

}

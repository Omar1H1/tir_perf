package fr.maif.tirperf.serviceTest.Mock;

import fr.maif.tirperf.model.Applicatif;
import fr.maif.tirperf.model.TirPerf;
import fr.maif.tirperf.repository.TirPerfRepository;
import fr.maif.tirperf.service.TirPerfService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TirPerfServiceMockTest {

    @Mock
    private TirPerfRepository tirPerfRepository;

    @InjectMocks
    private TirPerfService tirPerfService;

    private TirPerf tirPerf;
    private Applicatif applicatif;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        applicatif = Applicatif.builder()
                .id(1L)
                .intitule("MR")
                .build();
        tirPerf = TirPerf.builder()
                .id(1L)
                .reference("tirperf mr")
                .applicatif(applicatif)
                .build();
    }

    @Test
    void testSaveTirPerf() {
        when(tirPerfRepository.save(any(TirPerf.class))).thenReturn(tirPerf);

        TirPerf savedTirPerf = tirPerfService.saveTirPerf(tirPerf);

        assertNotNull(savedTirPerf);
        assertEquals(tirPerf.getId(), savedTirPerf.getId());
        verify(tirPerfRepository, times(1)).save(tirPerf);
    }

    @Test
    void testGetTirPerfById() {
        when(tirPerfRepository.findById(1L)).thenReturn(Optional.of(tirPerf));

        TirPerf foundTirPerf = tirPerfService.getTirPerfById(1L);

        assertNotNull(foundTirPerf);
        assertEquals(tirPerf.getId(), foundTirPerf.getId());
        verify(tirPerfRepository, times(1)).findById(1L);
    }

    @Test
    void testGetTirPerfById_NotFound() {
        when(tirPerfRepository.findById(2L)).thenReturn(Optional.empty());

        TirPerf foundTirPerf = tirPerfService.getTirPerfById(2L);

        assertNull(foundTirPerf);
        verify(tirPerfRepository, times(1)).findById(2L);
    }

    @Test
    void testDeleteTirPerf() {
        doNothing().when(tirPerfRepository).delete(any(TirPerf.class));

        tirPerfService.deleteTirPerf(tirPerf.getId());

        verify(tirPerfRepository, times(1)).deleteById(tirPerf.getId());
    }

    @Test
    void testGetAllTirPerf() {
        when(tirPerfRepository.findAll()).thenReturn(List.of(tirPerf));

        List<TirPerf> tirPerfs = tirPerfService.getAllTirPerf();

        assertNotNull(tirPerfs);
        assertTrue(tirPerfs.contains(tirPerf));
        verify(tirPerfRepository, times(1)).findAll();
    }

    @Test
    void testGetTirPerfsAssociatedToApplicatif() {
        when(tirPerfRepository.findByApplicatif(applicatif)).thenReturn(List.of(tirPerf));

        List<TirPerf> tirPerfs = tirPerfService.getTirPerfsAssociatedToApplicatif(applicatif);

        assertNotNull(tirPerfs);
        assertTrue(tirPerfs.contains(tirPerf));
        verify(tirPerfRepository, times(1)).findByApplicatif(applicatif);
    }
}




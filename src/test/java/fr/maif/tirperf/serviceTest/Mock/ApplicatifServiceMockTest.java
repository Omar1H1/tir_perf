package fr.maif.tirperf.serviceTest.Mock;



import fr.maif.tirperf.model.Applicatif;
import fr.maif.tirperf.repository.ApplicatifRepository;
import fr.maif.tirperf.service.ApplicatifService;
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

class ApplicatifServiceMockTest {

    @Mock
    private ApplicatifRepository applicatifRepository;

    @InjectMocks
    private ApplicatifService applicatifService;

    private Applicatif applicatif;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        applicatif = new Applicatif();
        applicatif.setId(1L);
        applicatif.setIntitule("Test Applicatif");
    }

    @Test
    void testSaveApplicatif() {
        when(applicatifRepository.save(any(Applicatif.class))).thenReturn(applicatif);

        Applicatif savedApplicatif = applicatifService.saveApplicatif(applicatif);

        assertNotNull(savedApplicatif);
        assertEquals("Test Applicatif", savedApplicatif.getIntitule());
        verify(applicatifRepository, times(1)).save(applicatif);
    }

    @Test
    void testGetApplicatifByIntitule() {
        when(applicatifRepository.findByIntitule("Test Applicatif")).thenReturn(Optional.of(applicatif));

        Optional<Applicatif> foundApplicatif = applicatifService.getApplicatifByIntitule("Test Applicatif");

        assertTrue(foundApplicatif.isPresent());
        assertEquals("Test Applicatif", foundApplicatif.get().getIntitule());
        verify(applicatifRepository, times(1)).findByIntitule("Test Applicatif");
    }

    @Test
    void testDeleteApplicatif() {
        applicatifService.deleteApplicatif(applicatif.getId());
        verify(applicatifRepository, times(1)).deleteById(applicatif.getId());
    }

    @Test
    void testUpdateApplicatif() {
        when(applicatifRepository.save(any(Applicatif.class))).thenReturn(applicatif);

        Applicatif updatedApplicatif = applicatifService.updateApplicatif(applicatif);

        assertNotNull(updatedApplicatif);
        assertEquals("Test Applicatif", updatedApplicatif.getIntitule());
        verify(applicatifRepository, times(1)).save(applicatif);
    }

    @Test
    void testGetApplicatifById() {
        when(applicatifRepository.findById(1L)).thenReturn(Optional.of(applicatif));

        Applicatif foundApplicatif = applicatifService.getApplicatifById(1L);

        assertNotNull(foundApplicatif);
        assertEquals("Test Applicatif", foundApplicatif.getIntitule());
        verify(applicatifRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllApplicatifs() {
        when(applicatifRepository.findAll()).thenReturn(List.of(applicatif));

        Iterable<Applicatif> applicatifs = applicatifService.getAllApplicatifs();

        assertNotNull(applicatifs);
        assertTrue(applicatifs.iterator().hasNext());
        verify(applicatifRepository, times(1)).findAll();
    }
}

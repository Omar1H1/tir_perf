package fr.maif.tirperf.serviceTest.Integration;


import fr.maif.tirperf.model.Applicatif;
import fr.maif.tirperf.repository.ApplicatifRepository;
import fr.maif.tirperf.service.ApplicatifService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ApplicatifServiceIntegrationTest {

    @Autowired
    private ApplicatifService applicatifService;

    @Autowired
    private ApplicatifRepository applicatifRepository;

    private Applicatif applicatif;

    @BeforeEach
    void setUp() {
        applicatif = new Applicatif();
        applicatif.setIntitule("Integration Test Applicatif");
        applicatifService.saveApplicatif(applicatif);
    }

    @Test
    void testSaveAndRetrieveApplicatif() {
        Applicatif foundApplicatif = applicatifService.getApplicatifById(applicatif.getId());

        assertThat(foundApplicatif).isNotNull();
        assertThat(foundApplicatif.getIntitule()).isEqualTo("Integration Test Applicatif");
    }

    @Test
    void testUpdateApplicatif() {
        applicatif.setIntitule("Updated Applicatif");
        applicatifService.updateApplicatif(applicatif);

        Applicatif updatedApplicatif = applicatifService.getApplicatifById(applicatif.getId());
        assertThat(updatedApplicatif.getIntitule()).isEqualTo("Updated Applicatif");
    }

    @Test
    void testDeleteApplicatif() {
        applicatifService.deleteApplicatif(applicatif.getId());
        Applicatif deletedApplicatif = applicatifService.getApplicatifById(applicatif.getId());

        assertThat(deletedApplicatif).isNull();
    }

    @Test
    void testGetAllApplicatifs() {
        List<Applicatif> applicatifs = applicatifService.getAllApplicatifs();

        assertThat(applicatifs).isNotEmpty();
    }
}

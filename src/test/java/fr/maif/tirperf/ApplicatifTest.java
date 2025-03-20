package fr.maif.tirperf;

import fr.maif.tirperf.model.Applicatif;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicatifTest {

  @Test
  void testApplicatifCreation () {

    Applicatif applicatif = Applicatif.builder()
    .Id(1L)
    .intitule("MR")
    .build();
    assertEquals(1L, applicatif.getId());
    assertEquals("MR", applicatif.getIntitule());
  }
}

package fr.maif.tirperf.modelTest;

import fr.maif.tirperf.model.Applicatif;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicatifTest {

  @Test
  void testApplicatifCreation () {

    Applicatif applicatif = Applicatif.builder()
    .id(1L)
    .intitule("MR")
    .build();
    assertEquals(1L, applicatif.getId());
    assertEquals("MR", applicatif.getIntitule());
  }
}

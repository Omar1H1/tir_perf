package fr.maif.tirperf;

import org.junit.jupiter.api.Test;

import fr.maif.tirperf.model.RapportExecution;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RapportExecutionTest {

  @Test
  void testCreateRapportExecution() {


    RapportExecution rapportExecution = RapportExecution.builder()
    .tempsAppels("{\"key\":\"value\"}")
    .nbApeel(10)
    .tauxSuccessKo(5)
    .erruers(Arrays.asList("Error1", "Error2"))
    .minDuration(100)
    .maxDuration(500)
    .avgDuration(300)
    .medianDuration(250)
    .build();

    assertEquals("{\"key\":\"value\"}", rapportExecution.getTempsAppels());
    assertEquals(10, rapportExecution.getNbApeel());
    assertEquals(5, rapportExecution.getTauxSuccessKo());
    assertEquals(Arrays.asList("Error1", "Error2"), rapportExecution.getErruers());
    assertEquals(100, rapportExecution.getMinDuration());
    assertEquals(500, rapportExecution.getMaxDuration());
    assertEquals(300, rapportExecution.getAvgDuration());
    assertEquals(250, rapportExecution.getMedianDuration());
  }
}

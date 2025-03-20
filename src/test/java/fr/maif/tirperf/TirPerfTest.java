package fr.maif.tirperf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import fr.maif.tirperf.model.ContextExecution;
import fr.maif.tirperf.model.RapportExecution;
import fr.maif.tirperf.model.Scenario;
import fr.maif.tirperf.model.TirPerf;

class TirPerfTest {


  @Test
  void testTirPerfBuilder() {

    RapportExecution rapportExecution = new RapportExecution();
    ContextExecution contextExecution = new ContextExecution();
    Scenario scenario = new Scenario();

    TirPerf tirPerf = TirPerf.builder()
    .reference("REF-123")
    .tirperfDate(new Timestamp(System.currentTimeMillis()))
    .rapport(rapportExecution)
    .context(contextExecution)
    .scenario(scenario)
    .build();

    assertEquals("REF-123", tirPerf.getReference());
    assertNotNull(tirPerf.getTirperfDate());
    assertEquals(rapportExecution, tirPerf.getRapport());
    assertEquals(contextExecution, tirPerf.getContext());
    assertEquals(scenario, tirPerf.getScenario());
  }
}

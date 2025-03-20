package fr.maif.tirperf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.maif.tirperf.model.ContextExecution;

public class ContextExecutionTest {

  @Test
  void testCreateContextExecution () {
  
    ContextExecution contextExecution = ContextExecution.builder()
    .id(1L)
    .environnement("perf")
    .infoComplementaires("{cpu: '4', ram : '16'}")
    .build();


    assertEquals(1L, contextExecution.getId());
    assertEquals("perf", contextExecution.getEnvironnement());
    assertEquals("{cpu: '4', ram : '16'}", contextExecution.getInfoComplementaires());
    
    
  }
}

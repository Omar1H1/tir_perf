package fr.maif.tirperf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import fr.maif.tirperf.model.Scenario;

public class ScenarioTest {


  @Test
  void testCreateScenario() {

    Scenario scenario = Scenario.builder()
    .Id(1L)
    .reference("test 1")
    .description("MR en RECX")
    .tags(Set.of("mock"))
    .build();

    assertEquals(1L, scenario.getId());
    assertEquals("test 1", scenario.getReference());
    assertEquals("MR en RECX", scenario.getDescription());

    scenario.getTags().forEach((tag) -> {
      assertEquals("mock", tag);
    });
  }
}

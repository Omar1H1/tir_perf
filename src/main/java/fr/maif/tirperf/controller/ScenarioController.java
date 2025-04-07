package fr.maif.tirperf.controller;

import fr.maif.tirperf.model.Scenario;
import fr.maif.tirperf.service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/scenario")
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @PostMapping
    public ResponseEntity<Scenario> createScenario(@RequestBody Scenario scenario) {
        Scenario createdScenario = scenarioService.saveScenario(scenario);
        return ResponseEntity.status(201).body(createdScenario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scenario> getScenarioById(@PathVariable Long id) {
        Scenario scenario = scenarioService.getScenarioById(id);
        return scenario != null ? ResponseEntity.ok(scenario) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scenario> updateScenario(@PathVariable Long id, @RequestBody Scenario scenario) {
        scenario.setId(id);
        Scenario updatedScenario = scenarioService.updateScenario(scenario);
        return ResponseEntity.ok(updatedScenario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScenario(@PathVariable Long id) {
        scenarioService.deleteScenario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Scenario>> getAllScenarios() {
        List<Scenario> scenarios = scenarioService.getAllScenarios();
        return ResponseEntity.ok(scenarios);
    }

    @GetMapping("/reference/{reference}")
    public ResponseEntity<Scenario> getScenarioByReference(@PathVariable String reference) {
        Scenario scenario = scenarioService.getScenarioByReference(reference);
        return scenario != null ? ResponseEntity.ok(scenario) : ResponseEntity.notFound().build();
    }
}
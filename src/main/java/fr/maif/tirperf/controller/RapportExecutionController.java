package fr.maif.tirperf.controller;

import fr.maif.tirperf.model.RapportExecution;
import fr.maif.tirperf.service.RapportExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rapportexecution")
public class RapportExecutionController {

    @Autowired
    private RapportExecutionService rapportExecutionService;

    @PostMapping
    public ResponseEntity<RapportExecution> createRapportExecution(@RequestBody RapportExecution rapportExecution) {
        RapportExecution createdRapportExecution = rapportExecutionService.saveRapportExecution(rapportExecution);
        return ResponseEntity.status(201).body(createdRapportExecution);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RapportExecution> getRapportExecutionById(@PathVariable Long id) {
        RapportExecution rapportExecution = rapportExecutionService.getRapportExecutionById(id);
        return rapportExecution != null ? ResponseEntity.ok(rapportExecution) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RapportExecution> updateRapportExecution(@PathVariable Long id, @RequestBody RapportExecution rapportExecution) {
        rapportExecution.setId(id);
        RapportExecution updatedRapportExecution = rapportExecutionService.updateRapportExecution(rapportExecution);
        return ResponseEntity.ok(updatedRapportExecution);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapportExecution(@PathVariable Long id) {
        rapportExecutionService.deleteRapportExecution(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RapportExecution>> getAllRapportExecutions() {
        List<RapportExecution> rapportExecutions = rapportExecutionService.getAllRapportExecutions();
        return ResponseEntity.ok(rapportExecutions);
    }
}
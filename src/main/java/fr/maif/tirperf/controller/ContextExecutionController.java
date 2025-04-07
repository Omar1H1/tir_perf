package fr.maif.tirperf.controller;

import fr.maif.tirperf.model.ContextExecution;
import fr.maif.tirperf.service.ContextExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contextexecution")
public class ContextExecutionController {

    @Autowired
    private ContextExecutionService contextExecutionService;

    @PostMapping
    public ResponseEntity<ContextExecution> createContextExecution(@RequestBody ContextExecution contextExecution) {
        ContextExecution createdContextExecution = contextExecutionService.saveContextExecution(contextExecution);
        return ResponseEntity.status(201).body(createdContextExecution);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContextExecution> getContextExecutionById(@PathVariable Long id) {
        ContextExecution contextExecution = contextExecutionService.getContextExecutionById(id);
        return contextExecution != null ? ResponseEntity.ok(contextExecution) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContextExecution> updateContextExecution(@PathVariable Long id, @RequestBody ContextExecution contextExecution) {
        contextExecution.setId(id);
        ContextExecution updatedContextExecution = contextExecutionService.updateContextExecution(contextExecution);
        return ResponseEntity.ok(updatedContextExecution);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContextExecution(@PathVariable Long id) {
        contextExecutionService.deleteContextExecution(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ContextExecution>> getAllContextExecutions() {
        List<ContextExecution> contextExecutions = contextExecutionService.getAllContextExecutions();
        return ResponseEntity.ok(contextExecutions);
    }
}
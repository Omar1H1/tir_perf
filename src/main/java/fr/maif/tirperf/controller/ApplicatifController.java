package fr.maif.tirperf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.maif.tirperf.model.Applicatif;
import fr.maif.tirperf.service.ApplicatifService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applicatif")
public class ApplicatifController {

  @Autowired
  private ApplicatifService applicatifService;

  @PostMapping
  public ResponseEntity<Applicatif> createApplicatif(@RequestBody Applicatif applicatif) {
    Applicatif createdApplicatif = applicatifService.saveApplicatif(applicatif);
    return ResponseEntity.status(201).body(createdApplicatif);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Applicatif> getApplicatifById(@PathVariable Long id) {
    Applicatif applicatif = applicatifService.getApplicatifById(id);
    return applicatif != null ? ResponseEntity.ok(applicatif) : ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Applicatif> updateApplicatif(@PathVariable Long id, @RequestBody Applicatif applicatif) {
    applicatif.setId(id);
    Applicatif updatedApplicatif = applicatifService.updateApplicatif(applicatif);
    return ResponseEntity.ok(updatedApplicatif);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteApplicatif(@PathVariable Long id) {
    applicatifService.deleteApplicatif(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<Applicatif>> getAllApplicatifs() {
    List<Applicatif> applicatifs = applicatifService.getAllApplicatifs();
    return ResponseEntity.ok(applicatifs);
  }
}
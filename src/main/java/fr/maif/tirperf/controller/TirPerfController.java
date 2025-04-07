package fr.maif.tirperf.controller;

import fr.maif.tirperf.model.TirPerf;
import fr.maif.tirperf.service.TirPerfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tirperf")
public class TirPerfController {

    @Autowired
    private TirPerfService tirPerfService;

    @PostMapping
    public ResponseEntity<TirPerf> createTirPerf(@RequestBody TirPerf tirPerf) {
        TirPerf createdTirPerf = tirPerfService.saveTirPerf(tirPerf);
        return ResponseEntity.status(201).body(createdTirPerf);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TirPerf> getTirPerfById(@PathVariable Long id) {
        TirPerf tirPerf = tirPerfService.getTirPerfById(id);
        return tirPerf != null ? ResponseEntity.ok(tirPerf) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TirPerf> updateTirPerf(@PathVariable Long id, @RequestBody TirPerf tirPerf) {
        tirPerf.setId(id);
        TirPerf updatedTirPerf = tirPerfService.saveTirPerf(tirPerf);
        return ResponseEntity.ok(updatedTirPerf);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTirPerf(@PathVariable Long id) {
        tirPerfService.deleteTirPerf(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TirPerf>> getAllTirPerf() {
        List<TirPerf> tirPerfList = tirPerfService.getAllTirPerf();
        return ResponseEntity.ok(tirPerfList);
    }
}
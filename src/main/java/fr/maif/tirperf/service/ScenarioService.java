package fr.maif.tirperf.service;

import fr.maif.tirperf.model.Scenario;
import fr.maif.tirperf.repository.ScenarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;

    public ScenarioService(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    public Scenario saveScenario(Scenario scenario) {
        return scenarioRepository.save(scenario);
    }

    public void deleteScenario(Long id) {
        scenarioRepository.deleteById(id);
    }

    public Scenario updateScenario(Scenario scenario) {
        return scenarioRepository.save(scenario);
    }

    public List<Scenario> getAllScenarios() {
        return scenarioRepository.findAll();
    }

    public Scenario getScenarioById(Long id) {
        return scenarioRepository.findById(id).orElse(null);
    }

    public Scenario getScenarioByReference(String reference) {
        return scenarioRepository.findByReference(reference).orElse(null);
    }
}

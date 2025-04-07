package fr.maif.tirperf.service;

import fr.maif.tirperf.model.RapportExecution;
import fr.maif.tirperf.repository.RapportExecutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportExecutionService {

    private final RapportExecutionRepository rapportExecutionRepository;

    public RapportExecutionService(RapportExecutionRepository rapportExecutionRepository) {
        this.rapportExecutionRepository = rapportExecutionRepository;
    }

    public RapportExecution saveRapportExecution(RapportExecution rapportExecution) {
        return rapportExecutionRepository.save(rapportExecution);
    }

    public RapportExecution getRapportExecutionById(Long id) {
        return rapportExecutionRepository.findById(id).orElse(null);
    }

    public void deleteRapportExecution(Long id) {
        rapportExecutionRepository.deleteById(id);
    }

    public RapportExecution updateRapportExecution(RapportExecution rapportExecution) {
        return rapportExecutionRepository.save(rapportExecution);
    }

    public List<RapportExecution> getAllRapportExecutions() {
        return rapportExecutionRepository.findAll();
    }
}

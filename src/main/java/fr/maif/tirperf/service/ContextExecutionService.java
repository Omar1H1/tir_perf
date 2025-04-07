package fr.maif.tirperf.service;

import fr.maif.tirperf.model.ContextExecution;
import fr.maif.tirperf.repository.ContextExecutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextExecutionService {

    private final ContextExecutionRepository contextExecutionRepository;

    public ContextExecutionService(ContextExecutionRepository contextExecutionRepository) {
        this.contextExecutionRepository = contextExecutionRepository;
    }

    public ContextExecution saveContextExecution(ContextExecution contextExecution) {
        return contextExecutionRepository.save(contextExecution);
    }

    public ContextExecution updateContextExecution(ContextExecution contextExecution) {
        return contextExecutionRepository.save(contextExecution);
    }

    public void deleteContextExecution(Long id) {
        contextExecutionRepository.deleteById(id);
    }

    public List<ContextExecution> getAllContextExecutions() {
        return contextExecutionRepository.findAll();
    }

    public ContextExecution getContextExecutionById(Long id) {
        return contextExecutionRepository.findById(id).orElse(null);
    }
}

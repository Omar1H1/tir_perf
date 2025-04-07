package fr.maif.tirperf.repository;

import fr.maif.tirperf.model.ContextExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextExecutionRepository extends JpaRepository<ContextExecution, Long> {}
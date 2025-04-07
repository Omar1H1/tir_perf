package fr.maif.tirperf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.maif.tirperf.model.RapportExecution;

@Repository
public interface RapportExecutionRepository extends JpaRepository<RapportExecution, Long> {

}

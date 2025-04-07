package fr.maif.tirperf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.maif.tirperf.model.Scenario;

import java.util.Optional;


@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Long > {

    Optional<Scenario> findByReference(String reference);
}

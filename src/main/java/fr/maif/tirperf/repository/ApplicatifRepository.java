package fr.maif.tirperf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.maif.tirperf.model.Applicatif;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicatifRepository extends JpaRepository<Applicatif, Long> {

    Optional<Applicatif> findByIntitule(String intitule);
}
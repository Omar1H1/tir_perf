package fr.maif.tirperf.repository;

import fr.maif.tirperf.model.Applicatif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.maif.tirperf.model.TirPerf;

import java.util.List;

@Repository
public interface TirPerfRepository extends JpaRepository<TirPerf, Long> {

    List<TirPerf> findByApplicatif(Applicatif applicatif);
}

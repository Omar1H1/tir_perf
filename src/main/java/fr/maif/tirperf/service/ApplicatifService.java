package fr.maif.tirperf.service;

import fr.maif.tirperf.model.Applicatif;
import fr.maif.tirperf.repository.ApplicatifRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicatifService {

    private final ApplicatifRepository applicatifRepository;

    public ApplicatifService(ApplicatifRepository applicatifRepository) {
        this.applicatifRepository = applicatifRepository;
    }

    public Applicatif saveApplicatif(Applicatif applicatif) {
        return applicatifRepository.save(applicatif);
    }

    public Optional<Applicatif> getApplicatifByIntitule(String intitule) {
        return applicatifRepository.findByIntitule(intitule);
    }

    public void deleteApplicatif(Long id) {
        applicatifRepository.deleteById(id);
    }

    public Applicatif updateApplicatif(Applicatif applicatif) {
        return applicatifRepository.save(applicatif);
    }

    public Applicatif getApplicatifById(Long id) {
        return applicatifRepository.findById(id).orElse(null);
    }

    public List<Applicatif> getAllApplicatifs() {
        return applicatifRepository.findAll();
    }
}
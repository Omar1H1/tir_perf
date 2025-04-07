package fr.maif.tirperf.service;

import fr.maif.tirperf.model.Applicatif;
import fr.maif.tirperf.model.TirPerf;
import fr.maif.tirperf.repository.TirPerfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TirPerfService {

    private final TirPerfRepository tirPerfRepository;


    public TirPerfService(TirPerfRepository tirPerfRepository) {
        this.tirPerfRepository = tirPerfRepository;
    }

    public TirPerf saveTirPerf (TirPerf tirPerf) {
        return tirPerfRepository.save(tirPerf);
    }

    public TirPerf getTirPerfById(Long id) {
        return tirPerfRepository.findById(id).orElse(null);
    }

    public List<TirPerf> getTirPerfsAssociatedToApplicatif(Applicatif applicatif) {
        return  tirPerfRepository.findByApplicatif(applicatif);
    }

    public void deleteTirPerf (Long id) {
        tirPerfRepository.deleteById(id);
    }

    public List<TirPerf> getAllTirPerf () {
        return tirPerfRepository.findAll();
    }

}

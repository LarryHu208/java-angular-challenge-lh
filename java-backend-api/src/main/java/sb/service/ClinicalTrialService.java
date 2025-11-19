package sb.service;

import org.springframework.stereotype.Service;
import sb.model.ClinicalTrial;
import sb.repository.ClinicalTrialRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ClinicalTrialService {
    private final ClinicalTrialRepository repository;
    public ClinicalTrialService(ClinicalTrialRepository repository) {
        this.repository = repository;
    }

    public List<ClinicalTrial> getAllTrials() {
        return repository.findAll();
    }

    public Optional<ClinicalTrial> getTrialById(String id) {
        return repository.findByNctId(id);
    }
}

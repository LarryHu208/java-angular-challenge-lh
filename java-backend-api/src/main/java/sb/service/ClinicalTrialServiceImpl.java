package sb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sb.model.ClinicalTrial;
import sb.model.ClinicalTrialDto;
import sb.repository.ClinicalTrialRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ClinicalTrialServiceImpl implements ClinicalTrialService {
    private static final Logger log = LoggerFactory.getLogger(ClinicalTrialServiceImpl.class);

    private final ClinicalTrialRepository repository;

    public ClinicalTrialServiceImpl(ClinicalTrialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClinicalTrialDto> getAllTrials() {
        List<ClinicalTrial> trials =  repository.findAll();
        log.info("Found {} trials", trials.size());
        return trials.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ClinicalTrialDto getTrialById(String id) {
        ClinicalTrial trial =  repository.findByNctId(id)
                .orElseThrow(() -> new NoSuchElementException("No trial found for id: " + id));
        log.info("Found trial with id: {}", trial.getNctId());
        return toDto(trial);
    }

    private ClinicalTrialDto toDto(ClinicalTrial t) {
        return new ClinicalTrialDto(
                t.getNctId(),
                t.getOfficialTitle(),
                t.getPhase(),
                t.getPrimaryCompletionDate()
        );
    }
}

package sb.service;

import org.springframework.stereotype.Service;
import sb.model.ClinicalTrial;
import sb.model.ClinicalTrialDto;
import sb.repository.ClinicalTrialRepository;

import java.util.List;
import java.util.Optional;


@Service
public interface ClinicalTrialService {
    List<ClinicalTrialDto> getAllTrials();
    ClinicalTrialDto getTrialById(String id);
}

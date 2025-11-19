package sb.controller;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import sb.repository.ClinicalTrialRepository;
import sb.model.ClinicalTrial;
import sb.model.ClinicalTrialDto;


@RestController
@RequestMapping("/clinicaltrial")
public class ClinicalTrialController {

    private static final Logger log = LoggerFactory.getLogger(ClinicalTrialController.class);

    private final ClinicalTrialRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClinicalTrialController(ClinicalTrialRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void debugTrials() {
        System.out.println("Rows in DB: " + repository.count());
    }

    @GetMapping("/hello")
    public String index() {
        return "Hello from ClinicalTrials API!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalTrialDto> getTrialById(@PathVariable String id) {
        Optional<ClinicalTrial> trialOpt = repository.findByNctId(id);

        return trialOpt
                .map(trial -> ResponseEntity.ok(toDto(trial)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ClinicalTrialDto> getAllTrials() {
        log.info("Fetching all trials");
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
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

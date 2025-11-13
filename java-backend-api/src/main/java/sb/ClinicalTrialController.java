package sb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


// currently the data from clinalTrial Controller is hard coded, we would want to return the data to be read from data.sql

// we would be using postgres to view the data

// steps read data from datasql

// We want to enhance the code to use the postgres data to add into clinical trial

// this would be each clinical trial that we want to put into: public ClinicalTrial(String nctId, String officialTitle, String phase, Date primaryCompletionDate)

// after adding into clinicaltrial.

// we want to when we initialize Clinical Trial Controller to directly access from data.sql instead of the hard code.

// this means @GetMapping("/clinicaltrial/{id}/") would be able to access any of the ClinicalTrials from data.sql

// Solution 1: manual solution woudl be insert from DB to clincalTrialControoler then we would access.

//
@RestController
@RequestMapping("/clinicaltrial")
public class ClinicalTrialController {

    //private ArrayList<ClinicalTrial> trials = new ArrayList<ClinicalTrial>();

    //    public ClinicalTrialController() {
//        Date d = Date.from(ZonedDateTime.parse("2018-01-01T00:00:00+00:00").toInstant());
//        trials.add(new ClinicalTrial("NCT00002537",
//                "A PHASE I STUDY OF PROLONGED LOW-DOSE TOPOTECAN INFUSION COMBINED WITH CHEST " +
//                        "IRRADIATION",
//                "I", d));
//        trials.add(new ClinicalTrial("NCT00002556",
//                "The Treatment of Multiple Myeloma Utilizing VBMCP Chemotherapy Alternating with " +
//                        "High-Dose Cyclophosphamide and Alpha2b-Interferon Versus VBMCP: A Phase " +
//                        "III Study for Previously Untreated Multiple Myeloma",
//                "III", d));
//    }

    private final ClinicalTrialRepository repository;

    @Autowired
    public ClinicalTrialController(ClinicalTrialRepository repository) {
        this.repository = repository;
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
    public ClinicalTrial getTrialById(@PathVariable String id) {
        Optional<ClinicalTrial> trialOpt = repository.findByNctId(id);
        return trialOpt.orElse(null);
    }

    @GetMapping
    public List<ClinicalTrial> getAllTrials() {
        return repository.findAll();
    }

}

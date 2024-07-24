package sb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class ClinicalTrialController {

    private final ArrayList<ClinicalTrial> trials = new ArrayList<ClinicalTrial>();

    public ClinicalTrialController() {
        Date d = Date.from(ZonedDateTime.parse("2018-01-01T00:00:00+00:00").toInstant());
        trials.add(new ClinicalTrial("NCT00002537",
                "A PHASE I STUDY OF PROLONGED LOW-DOSE TOPOTECAN INFUSION COMBINED WITH CHEST " +
                        "IRRADIATION",
                "I", d));
        trials.add(new ClinicalTrial("NCT00002556",
                "The Treatment of Multiple Myeloma Utilizing VBMCP Chemotherapy Alternating with " +
                        "High-Dose Cyclophosphamide and Alpha2b-Interferon Versus VBMCP: A Phase " +
                        "III Study for Previously Untreated Multiple Myeloma",
                "III", d));
    }



    @GetMapping("/")
    public String index() {
        return "Hello from ClinicalTrials API!";
    }

    @GetMapping("/clinicaltrial/{id}/")
    public ClinicalTrial getTrialById(@PathVariable String id) {
        return new ClinicalTrial();
    }

    @GetMapping("/clinicaltrial")
    public ClinicalTrial[] getAllTrials() {
        return trials.toArray(new ClinicalTrial[trials.size()]);
    }
}

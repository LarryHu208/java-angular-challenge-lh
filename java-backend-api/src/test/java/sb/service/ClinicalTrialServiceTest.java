package sb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sb.model.ClinicalTrialDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ClinicalTrialServiceTest {

    @Autowired
    ClinicalTrialService service;

    @Test
    void testGetAllTrials() {
        List<ClinicalTrialDto> result = service.getAllTrials();

        // data.sql has 3 rows
        assertFalse(result.isEmpty());
        assertEquals(314, result.size());
    }

    @Test
    void testGetTrialById() {
        ClinicalTrialDto result = service.getTrialById("NCT00002537");

        // Just basic sanity checks
        assertEquals("NCT00002537", result.nctId());
        assertFalse(result.officialTitle().isBlank());
    }
}
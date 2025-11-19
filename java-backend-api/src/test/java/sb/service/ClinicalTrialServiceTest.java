package sb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class ClinicalTrialServiceTest {
    @Autowired
    ClinicalTrialService service;

    @Test
    void testGetAllTrials() {
        var result = service.getAllTrials();
        assertFalse(result.isEmpty());
    }

    @Test
    void testGetTrialById() {
        var result = service.getTrialById("NCT00002537");
        assertFalse(result.isEmpty());
    }
}

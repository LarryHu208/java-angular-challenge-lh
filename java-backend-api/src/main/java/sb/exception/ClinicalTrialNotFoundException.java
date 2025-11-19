package sb.exception;

public class ClinicalTrialNotFoundException extends RuntimeException {
    public ClinicalTrialNotFoundException(String nctId) {
        super("Clinical trial not found with nctId: " + nctId);
    }
}

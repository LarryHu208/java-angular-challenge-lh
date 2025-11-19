package sb.model;

import java.util.Date;

public record ClinicalTrialDto (
    String nctId,
    String officialTitle,
    String phase,
    Date primaryCompletionDate
) {}


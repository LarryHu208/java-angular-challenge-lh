package sb;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ClinicalTrial implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    private String nctId;
    private String officialTitle;
    private String phase;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date primaryCompletionDate;

    public ClinicalTrial(){

    }

    public ClinicalTrial(String nctId, String officialTitle, String phase, Date primaryCompletionDate) {
        this.nctId = nctId;
        this.officialTitle = officialTitle;
        this.phase = phase;
        this.primaryCompletionDate = primaryCompletionDate;
    }

    public String getNctId() {
        return this.nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId;
    }

    public String getOfficialTitle() {
        return this.officialTitle;
    }

    public void setOfficialTitle(String officialTitle) {
        this.officialTitle = officialTitle;
    }

    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Date getPrimaryCompletionDate() {
        return this.primaryCompletionDate;
    }

    public void setPrimaryCompletionDate(Date primaryCompletionDate) {
        this.primaryCompletionDate = primaryCompletionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClinicalTrial)) {
            return false;
        }
        ClinicalTrial clinicalTrial = (ClinicalTrial) o;
        return Objects.equals(nctId, clinicalTrial.nctId) && Objects.equals(officialTitle, clinicalTrial.officialTitle) && Objects.equals(phase, clinicalTrial.phase) && Objects.equals(primaryCompletionDate, clinicalTrial.primaryCompletionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nctId, officialTitle, phase, primaryCompletionDate);
    }

    @Override
    public String toString() {
        return "{" +
                " nctId='" + getNctId() + "'" +
                ", officialTitle='" + getOfficialTitle() + "'" +
                ", phase='" + getPhase() + "'" +
                ", primaryCompletionDate='" + getPrimaryCompletionDate() + "'" +
                "}";
    }


}
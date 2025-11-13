package sb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicalTrialRepository extends JpaRepository<ClinicalTrial, String> {
    Optional<ClinicalTrial> findByNctId(String nctId);
}

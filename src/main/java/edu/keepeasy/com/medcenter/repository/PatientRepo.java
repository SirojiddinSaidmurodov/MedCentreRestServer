package edu.keepeasy.com.medcenter.repository;

import edu.keepeasy.com.medcenter.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findById(long id);
}

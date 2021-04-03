package edu.keepeasy.com.medcenter.repository;

import edu.keepeasy.com.medcenter.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}

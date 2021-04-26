package edu.keepeasy.com.medcenter.repository;

import edu.keepeasy.com.medcenter.domain.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepo extends JpaRepository<Medicament, Long> {
}

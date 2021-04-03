package edu.keepeasy.com.medcenter.repository;

import edu.keepeasy.com.medcenter.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepo extends JpaRepository<Record, Long> {
}

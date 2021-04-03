package edu.keepeasy.com.medcenter.repository;

import edu.keepeasy.com.medcenter.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}

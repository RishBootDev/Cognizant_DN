package com.rishbootdev.ormqueryhandson.repository;

import com.rishbootdev.ormqueryhandson.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

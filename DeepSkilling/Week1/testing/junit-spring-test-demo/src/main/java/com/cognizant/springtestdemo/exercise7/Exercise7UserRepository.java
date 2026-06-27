package com.cognizant.springtestdemo.exercise7;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Exercise7UserRepository extends JpaRepository<Exercise7User, Long> {
    List<Exercise7User> findByName(String name);
}

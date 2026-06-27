package com.cognizant.mockitotestdemo.exercise1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("exercise1UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}

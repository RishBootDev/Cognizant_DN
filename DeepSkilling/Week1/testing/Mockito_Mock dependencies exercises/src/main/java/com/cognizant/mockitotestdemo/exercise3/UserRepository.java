package com.cognizant.mockitotestdemo.exercise3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("exercise3UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}

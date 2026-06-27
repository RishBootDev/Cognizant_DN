package com.cognizant.mockitotestdemo.exercise2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("exercise2UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}

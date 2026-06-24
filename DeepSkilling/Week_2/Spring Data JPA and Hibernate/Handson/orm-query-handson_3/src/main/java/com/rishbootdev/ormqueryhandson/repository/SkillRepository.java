package com.rishbootdev.ormqueryhandson.repository;

import com.rishbootdev.ormqueryhandson.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}

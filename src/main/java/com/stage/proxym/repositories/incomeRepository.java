package com.stage.proxym.repositories;

import com.stage.proxym.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface incomeRepository extends JpaRepository<Income, Long> {
}
